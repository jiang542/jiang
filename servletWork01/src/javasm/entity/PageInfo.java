package javasm.entity;



import javasm.constant.PageConstant;

import java.util.List;
import java.util.Objects;

/**
 * 分页信息
 * @param <T>
 */
public class PageInfo<T> {
    private Integer nowPage;//现在的页数
    private Integer pageNum;//每页数量
    private Integer total;//总条数
    private Integer sumPage;//总页数
    private Integer startIndex;//开始的下标
    private List<T> dateList;

    public PageInfo(Integer nowPage, Integer pageNum, Integer total) {
        int nowPage_text = nowPage!=null && !"".equals(nowPage) ? nowPage : 1;
        int pageNum_text = pageNum!=null && !"".equals(pageNum) ? pageNum : PageConstant.PAGENUM;
        this.total = total;

        //验证用户输入pageNum
        this.pageNum = pageNum_text<1 ? PageConstant.PAGENUM : pageNum_text;
        //计算总页数
        this.sumPage = this.total % this.pageNum==0 ? this.total/this.pageNum : this.total/this.pageNum+1;
        //验证用户输入nowpage
        this.nowPage = nowPage_text<1 ? 1 : nowPage_text;
        this.nowPage = this.nowPage>this.sumPage ? this.sumPage : nowPage;
        //计算其实下标
        this.startIndex = (this.nowPage-1)*this.pageNum;
    }

    public PageInfo(Integer nowPage, Integer pageNum) {
        this.nowPage = nowPage;
        this.pageNum = pageNum;
    }

    public PageInfo() {
    }

    public Integer getNowPage() {
        return nowPage;
    }

    public void setNowPage(Integer nowPage) {
        this.nowPage = nowPage;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getSumPage() {
        return sumPage;
    }

    public void setSumPage(Integer sumPage) {
        this.sumPage = sumPage;
    }

    public Integer getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(Integer startIndex) {
        this.startIndex = startIndex;
    }

    public List<T> getDateList() {
        return dateList;
    }

    public void setDateList(List<T> dateList) {
        this.dateList = dateList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PageInfo<?> pageInfo = (PageInfo<?>) o;
        return Objects.equals(nowPage, pageInfo.nowPage) &&
                Objects.equals(pageNum, pageInfo.pageNum) &&
                Objects.equals(total, pageInfo.total) &&
                Objects.equals(sumPage, pageInfo.sumPage) &&
                Objects.equals(startIndex, pageInfo.startIndex) &&
                Objects.equals(dateList, pageInfo.dateList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nowPage, pageNum, total, sumPage, startIndex, dateList);
    }

    @Override
    public String toString() {
        return "PageInfo{" +
                "nowPage=" + nowPage +
                ", pageNum=" + pageNum +
                ", total=" + total +
                ", sumPage=" + sumPage +
                ", startIndex=" + startIndex +
                ", dateList=" + dateList +
                '}';
    }
}
