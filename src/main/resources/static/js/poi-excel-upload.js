$(document).ready(function () {
  $(document).on("click", ".poi-upload-btn", function () {
    let fileData = $(".excel-file")[0].files[0];
    let formData = new FormData();

    formData.append("file",fileData);
    // $.ajax({
    //   url:'',
    //   type:'POST',
    //   // data:formData
    // })
  });
});
