package com.iu.main.board.qna;

import com.iu.main.board.BoardDTO;

public class QnaDTO extends BoardDTO {

	private Long ref;
	private Long step;
	private Long depth;
	
	
	public Long getRef() {
		return ref;
	}
	public Long getStep() {
		return step;
	}
	public Long getDepth() {
		return depth;
	}
	public void setRef(Long ref) {
		this.ref = ref;
	}
	public void setStep(Long step) {
		this.step = step;
	}
	public void setDepth(Long depth) {
		this.depth = depth;
	}
	
	
	
	

	
	
	
}
