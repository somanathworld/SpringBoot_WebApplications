package com.nt.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.nt.entity.MarriageSeekerInfo;
import com.nt.model.MarriageSeeker;
import com.nt.repository.IMarriageSeekerInfoRepo;

@Service
public class MatrimonyMgmtServiceImpl implements IMatrimonyMgmtService {

	@Autowired
	private IMarriageSeekerInfoRepo repo;

	@Autowired
	private Environment env;

	@Override
	public String processProfile(MarriageSeeker seeker) throws Exception {
		String location = env.getProperty("upload.store");
		File locationStore = new File(location);
		if (!locationStore.exists())
			locationStore.mkdir();

		MultipartFile resumeFile = seeker.getResume();
		MultipartFile photoFile = seeker.getPhoto();

		String resumeFileName = resumeFile.getOriginalFilename();
		String photoFileName = photoFile.getOriginalFilename();

		InputStream resumeStream = resumeFile.getInputStream();
		InputStream photoStream = photoFile.getInputStream();

		OutputStream resumeOStream = new FileOutputStream(location + "/" + resumeFileName);
		OutputStream photoOStream = new FileOutputStream(location + "/" + photoFileName);
		IOUtils.copy(resumeStream, resumeOStream);
		IOUtils.copy(photoStream, photoOStream);
		resumeStream.close();
		photoStream.close();
		resumeOStream.close();
		photoOStream.close();

		MarriageSeekerInfo info = new MarriageSeekerInfo();
		info.setProfileName(seeker.getProfileName());
		info.setGender(seeker.getGender());
		info.setResumePath(location + "/" + resumeFileName);
		info.setPhotoPath(location + "/" + photoFileName);

		String msg = registerProfile(info);

		return msg;
	}

	@Override
	public String registerProfile(MarriageSeekerInfo info) {
		System.out.println("MatrimonyMgmtServiceImpl.registerProfile()");
		return "Profile is registered with : " + repo.save(info).getProfileId();
	}

	@Override
	public Iterable<MarriageSeekerInfo> displayAllProfiles() {
		return repo.findAll();
	}

	@Autowired
	private ServletContext sc;

	@Override
	public void getFile(String filePath, HttpServletResponse res) throws Exception {
		// create java.io.File class object pointing to the file to download
		File file = new File(filePath);
		// get the length of the file and making it as the response content length
		res.setContentLengthLong(file.length());
		// get MIME of the file to be downloaded and make it as the response content
		// type
		String mimeType = sc.getMimeType(filePath);
		mimeType = mimeType != null ? mimeType : "application/octet-stream";
		res.setContentType(mimeType);
		// create InputStream pointing to the file to be download
		InputStream is = new FileInputStream(filePath);
		// create OutputStream pointing to the response object
		OutputStream os = res.getOutputStream();
		// give information to browser to make the received content as the downloadable
		// file
		res.setHeader("Content-Disposition", "attachment;fileName=" + file.getName());
		// copy file to be download content to response object
		IOUtils.copy(is, os);
		// close stream
		is.close();
		os.close();
	}
}
