package com.iu.main.util;

public class Pager {
	//검색
	private String kind;
	private String search;
	
	/////////////////////////////
	private Long startRow;
	private Long lastRow;
	
	private Long page;
	
	//한페이지에 보여질 data(row)의 갯수
	private Long perPage;
	
	//총 페이지의 갯수
	private Long totalPage;
	
	//시작번호
	private Long startNum;
	
	//끝번호
	private Long lastNum;
	
	//이전블럭활성화
	private boolean pre;  //false면 1번블럭, true면 1번 아님
	//다음블럭 활성화
	private boolean next; //false면 마지막블럭, true면 마지막블럭 아님
	
	public void makeRowNum() {
		this.startRow = (this.getPage()-1)*this.getPerPage()+1;
		this.lastRow = this.getPage()*this.getPerPage();
		
	}
	
	public void makePageNum(Long total) {
		//1. 전체 갯수로 전체 페이지 수 구하기
		this.totalPage = total/this.getPerPage();
		if(total%this.getPerPage()!=0) {
			this.totalPage++;
		}
		
		//2. 전체 페이지수로 전체 block 수 구하기
		
		long perBlock=5;//한페이지에 출력할 번호의 갯수
		
		long totalBlock = this.totalPage/perBlock;
		if(this.totalPage%perBlock!=0) {
			totalBlock++;
		}
		
		//3.현재 page번호로 블럭번호 구하기
		//현재 블록 번호
		long curBlock = this.getPage()/perBlock;
		if(this.getPage()%perBlock!=0) {
			curBlock++;
		}
		
		//4. 현재 블럭번호의 시작번호와 끝번호 구하기
		//curBlock  startNum  lastNum
		//		1			1			5
		//		2			6			10		
		//		3			11			15
		this.startNum=(curBlock-1)*perBlock+1;
		this.lastNum=curBlock*perBlock;
		
		//이전 블럭 활성화 여부
		if(curBlock>1) {
			this.pre = true;
		}
		
		//다음 블럭 활성화 여부
		if(curBlock<totalBlock) {
			this.next = true;
		}
		
		// 현재 블럭이 마지막 블럭번호와 같다면 lastNum을 totalBlock숫자를 대입
		if(!this.next) {
			this.lastNum=totalPage; 
		}
		
	}
	
	
	
	
	
	
	public String getKind() {
		return kind;
	}

	public String getSearch() {
		if(search==null) {
			search="";
		}
		return search;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public boolean isPre() {
		return pre;
	}

	public boolean isNext() {
		return next;
	}

	public void setPre(boolean pre) {
		this.pre = pre;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public Long getStartNum() {
		return startNum;
	}

	public Long getLastNum() {
		return lastNum;
	}

	public void setStartNum(Long startNum) {
		this.startNum = startNum;
	}

	public void setLastNum(Long lastNum) {
		this.lastNum = lastNum;
	}

	public Long getTotalPage() {
		return totalPage;
	}




	public void setTotalPage(Long totalPage) {
		this.totalPage = totalPage;
	}




	public Long getPage() {
		if(this.page==null) {
			this.page=1L;
		}
		return page;
	}



	public Long getPerPage() {
		if(this.perPage==null) {
			this.perPage=10L;
		}
		return perPage;
	}



	public void setPage(Long page) {
		this.page = page;
	}



	public void setPerPage(Long perpage) {
		
		this.perPage = perpage;
	}



	public Long getStartRow() {
		return startRow;
	}


	public Long getLastRow() {
		return lastRow;
	}


	public void setStartRow(Long startRow) {
		this.startRow = startRow;
	}


	public void setLastRow(Long lastRow) {
		this.lastRow = lastRow;
	}
	
	
}
