//跳转到多少页
function toPage(firstPage, lastPage) {
    var pageNum = Number($("#pageNum").val());
    firstPage = Number(firstPage);
    lastPage = Number(lastPage);

    /*
     * alert("firstPage: "+firstPage+ " lastPage: "+lastPage+" pageNum:
     * "+pageNum); alert(pageNum>lastPage);
     */

    pageNum = ((pageNum <= 0) ? firstPage : pageNum);
    pageNum = ((pageNum > lastPage) ? lastPage : pageNum);

    /* alert("调整之后的pageNum:"+pageNum); */

    location.href = "/index?pageNum=" + pageNum;
}