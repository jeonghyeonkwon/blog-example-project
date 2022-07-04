$(document).ready(function () {
  $(document).on("click", ".poi-upload-btn", function () {
    let fileData = $(".excel-file")[0].files[0];
    let formData = new FormData();

    formData.append("file",fileData);
    $.ajax({
      url:'/api/poi/upload',
      type:'POST',
      data:formData,
      contentType:false,
      processData:false,
      success:function (res){
        console.log(res);
        res.forEach(function(obj){
          $('tbody').append(initAdd(obj));
        })
      },
      error:function (err){
        console.log('잘못된 요청 입니다.')
      }
    })
  });
  function initAdd(obj){
    let initList = `
        <tr>
            <th scope="row">${obj.num}</th>
            <td>${obj.lastName}</td>
            <td>${obj.firstName}</td>
            <td>${obj.etc}</td>
        </tr>
    `;
    return initList;
  }
});
