package com.iu.main.qna;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class QnaController {
	@Autowired
	private QnaService qnaService;
}
