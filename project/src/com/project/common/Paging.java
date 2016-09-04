package com.project.common;


public class Paging {
    private int pageSize;		// 게시 글 수
    private int firstPageNo;	// 첫 번째 페이지 번호
    private int prevPageNo;		// 이전 페이지 번호
    private int startPageNo;	// 시작 페이지 (페이징 네비 기준)
    private int pageNo;			// 페이지 번호
    private int endPageNo;		// 끝 페이지 (페이징 네비 기준)
    private int nextPageNo;		// 다음 페이지 번호
    private int finalPageNo;	// 마지막 페이지 번호
    private int totalCount;		// 게시 글 전체 수
    private int curBlock;		// 현재 블럭
    private int pagePerBlock;	// 블럭당 페이지 수
    private int totalBlock;		// 총 블럭 수
    
    public Paging(){
    	this(1, 10);
    }
    
    public Paging(int pageNo, int pageSize) {
		super();
		this.pageNo = pageNo;
		this.pageSize = pageSize;
	}

	public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getFirstPageNo() {
        return firstPageNo;
    }

    public void setFirstPageNo(int firstPageNo) {
        this.firstPageNo = firstPageNo;
    }

    public int getPrevPageNo() {
        return prevPageNo;
    }

    public void setPrevPageNo(int prevPageNo) {
        this.prevPageNo = prevPageNo;
    }

    public int getStartPageNo() {
        return startPageNo;
    }

    public void setStartPageNo(int startPageNo) {
        this.startPageNo = startPageNo;
    }

     public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getEndPageNo() {
        return endPageNo;
    }

    public void setEndPageNo(int endPageNo) {
        this.endPageNo = endPageNo;
    }

    public int getNextPageNo() {
        return nextPageNo;
    }

    public void setNextPageNo(int nextPageNo) {
        this.nextPageNo = nextPageNo;
    }

    public int getFinalPageNo() {
        return finalPageNo;
    }

    public void setFinalPageNo(int finalPageNo) {
        this.finalPageNo = finalPageNo;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
        this.makePaging();
    }
    

    public int getCurBlock() {
		return curBlock;
	}

	public void setCurBlock(int curBlock) {
		this.curBlock = curBlock;
	}

	public int getPagePerBlock() {
		return pagePerBlock;
	}

	public void setPagePerBlock(int pagePerBlock) {
		this.pagePerBlock = pagePerBlock;
	}

	
	public int getTotalBlock() {
		return totalBlock;
	}

	public void setTotalBlock(int totalBlock) {
		this.totalBlock = totalBlock;
	}

	//  데이터 select할 때 시작번호
    public int getStart(){
    	int start = 0;
    	start = (pageNo - 1 ) * pageSize + 1;
    	return start;
    }
    
//  데이터 select할 때 끝번호
    public int getEnd(){
    	int end = 0;
    	int start = getStart();
    	end = start + pageSize - 1;
    	
    	return end;
    }

    
    private void makePaging() {
//    	 게시 글 전체 수가 없는 경우
    	if (this.totalCount == 0) return;

//    	기본값 설정
        if (this.pageNo == 0) this.setPageNo(1); 
        if (this.pageSize == 0) this.setPageSize(10); 
        if (this.pagePerBlock == 0) this.setPagePerBlock(5);

//      현재블럭 구하기
        int curBlock = (int) Math.ceil((double)this.pageNo/this.pagePerBlock);
        this.setCurBlock(curBlock);
        
//      총블럭 구하기
        int totalBlock = (int) Math.ceil((double)this.finalPageNo/this.pagePerBlock) + 1;
        this.setTotalBlock(totalBlock);
        
        
//      마지막 페이지 
        int finalPage = (totalCount + (pageSize - 1)) / pageSize;
        if (this.pageNo >= finalPage) this.setPageNo(finalPage);

//      현재 페이지 유효성 체크
        if (this.pageNo < 0 || this.pageNo > finalPage) this.pageNo = 1; 

        
//      시작 페이지 (전체)
        boolean isNowFirst = pageNo == 1 ? true : false;
//      마지막 페이지 (전체)
        boolean isNowFinal = pageNo == finalPage ? true : false; 

/*//      시작 페이지 (페이징 네비 기준)
        int startPage = ((pageNo - 1) / pageSize) * pageSize + 1;
//      끝페이지 (페이징네비기준)
        int endPage = startPage + pageSize - 1; */
        
//      시작페이지 (블럭기준)
        int startPage = (curBlock - 1) * pagePerBlock + 1;
//      끝 페이지 (블럭기준)
        int endPage = curBlock * pagePerBlock;

//      [마지막 페이지 (페이징 네비 기준) > 마지막 페이지] 보다 큰 경우
        if (endPage >= finalPage) { 
            endPage = finalPage;
        }
        
//      첫 번째 페이지 번호
        this.setFirstPageNo(1); 

        
        /*
//      이전 페이지 번호
        if (isNowFirst) {
            this.setPrevPageNo(1); 
        } else {
            this.setPrevPageNo(((pageNo - 1) < 1 ? 1 : (pageNo - 1))); 
        }*/
        
//      이전 페이지 번호
        if (isNowFirst) {
            this.setPrevPageNo(1); 
        } else {
            this.setPrevPageNo(((pageNo - 1) < 1 ? 1 : (pageNo - 1))); 
        }
        
        
//      시작 페이지 (페이징 네비 기준)
        this.setStartPageNo(startPage);
//      끝 페이지 (페이징 네비 기준)
        this.setEndPageNo(endPage); 

//      다음 페이지 번호
        if (isNowFinal) {
            this.setNextPageNo(finalPage); 
        } else {
            this.setNextPageNo(((pageNo + 1) > finalPage ? finalPage : (pageNo + 1))); 
        }
//      마지막 페이지 번호
        this.setFinalPageNo(finalPage); 
    }

	@Override
	public String toString() {
		return "Paging [pageSize=" + pageSize + ", firstPageNo=" + firstPageNo + ", prevPageNo=" + prevPageNo
				+ ", startPageNo=" + startPageNo + ", pageNo=" + pageNo + ", endPageNo=" + endPageNo + ", nextPageNo="
				+ nextPageNo + ", finalPageNo=" + finalPageNo + ", totalCount=" + totalCount + "]";
	}

/*  @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }*/
    
    
}