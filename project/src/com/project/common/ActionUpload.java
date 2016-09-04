package com.project.common;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

public interface ActionUpload {
	public void exectute(MultipartRequest multi,HttpServletResponse response)throws ServletException, IOException;

}
