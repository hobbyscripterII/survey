package egovframework.example.cmmn;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import egovframework.example.sample.service.BoardFileInsDto;

@Component
public class FileUtils {
	private final String prefixPath;
	Logger log = LoggerFactory.getLogger(getClass());

	// application.properties에 저장된 실제 로컬의 경로를 가져옴
	// 해당 변수는 빈 주입 시 초기화됨(생성자 주입)
	public FileUtils(@Value("${upload.prefix.path}") String prefixPath) {
		// this - 객체 주소값 참조
		// 지역 변수에 있는 값을 클래스의 멤버 변수에 참조 시킴
		this.prefixPath = prefixPath;
	}

	// 로컬에 저장될 UUID 추출
	private String getFileName() {
		return UUID.randomUUID().toString(); // 고유성이 보장되는 id(UUID) 생성 + string 형변환
	}

	public String getExt(MultipartFile file) {
		// 첨부파일의 실제 파일명(확장자가 포함되어 있음)
		String originalFileName = file.getOriginalFilename();
		// substring을 통해 제일 마지막에 있는 . 앞의 문자열을 자름 - 확장자 추출
		return originalFileName.substring(originalFileName.lastIndexOf("."));
	}

	private String getPath(String path) {
		// 로컬에 저장할 실제 경로를 가져옴
		Path getPath = Paths.get(prefixPath);
		// 반환하기 위해 string으로 형변환
		String savedPath = getPath.toString();

		// 해당 경로가 존재하는지 확인
		// 존재하지 않을 경우 아래의 로직을 실행함
		if (!Files.exists(getPath)) {
			// 존재하지 않을 경우 해당 디렉토리를 생성
			try {
				Files.createDirectories(getPath);
			}
			// 생성에 실패할 경우 예외 발생(수정 필요)
			catch (Exception e) {
				throw new RuntimeException();
			}
		}
		
		return savedPath;
	}

	public String getDownloadPath(String savedName) {
		// 실제 로컬에 저장될 '경로/UUID.확장명'
		return Paths.get(prefixPath, savedName).toString();
	}

	public BoardFileInsDto fileUpload(MultipartFile multipartFile) throws Exception {
		// 테이블에 저장할 데이터 추출
		// 확장자를 제외한 첨부파일명
		String originalName = FilenameUtils.removeExtension(multipartFile.getOriginalFilename());
		// 추출된 UUID
		String savedName = getFileName();
		// 첨부파일의 확장자
		String ext = getExt(multipartFile);
		// 로컬에 저장할 경로
		String savedPath = getPath(prefixPath);
		// 로컬에 저장할 풀 경로(경로/UUID.확장명)
		String uploadPath = savedPath + "/" + savedName + ext;
		// 해당 파일의 크기
		int fileSize = (int) multipartFile.getSize();

		// 파일 테이블에 저장 시 사용할 dto 객체 생성
		BoardFileInsDto dto = new BoardFileInsDto();
		dto.setOriginalName(originalName);
		dto.setSavedName(savedName);
		dto.setExt(ext);
		dto.setFileSize(fileSize);

		try {
			// 파일을 저장하기 위해 경로를 추상화시킨 File 객체 생성
			File file = new File(uploadPath);
			// 해당 경로에 파일 저장
			multipartFile.transferTo(file);
		} catch (Exception e) {
			// 저장에 실패할 경우 예외 발생(수정 필요)
			throw new Exception();
		}
		
		// 저장 후 dto 반환
		return dto;
	}
	
	public void deleteFile(String path) {
		try {
			// 로컬에 저장된 풀 경로를 가져옴(경로/UUID.확장명)
			String fullPath = getDownloadPath(path);
			// 파일을 삭제하기 위해 경로를 추상화시킨 File 객체 생성
			File file = new File(fullPath);
			// 파일 삭제
			file.delete();
		} catch (Exception e) {
			// 삭제에 실패할 경우 예외 발생(수정 필요)
			e.printStackTrace();
		}
	}
}
