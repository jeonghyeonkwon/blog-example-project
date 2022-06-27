$(document).ready(function () {
  // 폼 추가 클릭시
  $(document).on("click", ".btn-success", function () {
    // 폼이 하나라면
    if ($(".dynamic-form").length === 1) {
      // 초기에는 폼 삭제 버튼이 없다.
      // 새로운 폼 생성 되면 첫 번쨰 폼도 폼 삭제 버튼을 만들어 준다
      $(this).parents(".dynamic-button").append(removeFormButton);
    }
    $(this).remove();
    $(".dynamic-form").last().after(addForm());
  });
  // 폼 삭제 클릭시
  $(document).on("click", ".btn-danger", function () {
    let lastBtn = $(this).siblings(".btn-success").length;
    $(this).parents(".dynamic-form").remove();
    //마지막 폼 추가 폼 삭제 버튼이 있는 폼을 클릭했는가?
    if (lastBtn === 1) {
      //맞다면 마지막 폼에 (폼 추가) 버튼 추가
      $(".dynamic-form")
        .last()
        .find(".dynamic-button")
        .prepend(addFormButton());
    }
    //폼 검증 하나라면 폼
    validateRemoveButton();
  });
  // 바로 밑 추가 클릭시
  $(document).on("click", ".btn-primary", function () {
    $(this).parents(".dynamic-field").last().after(addField());
    $(this).remove();
  });
  // 폼 추가
  function addForm() {
    let formInit = `
        <div class="dynamic-form">
            <div class="dynamic-button">
                <button type="button" class="btn btn-success">폼 추가</button>
                <button type="button" class="btn btn-danger">폼 삭제</button>
            </div>
            <div class="dynamic-img">
                <img src="https://via.placeholder.com/150" class="img-thumbnail" />
            </div>
            <div class="dynamic-field">
                <input class="form-control form-control-lg" type="text" />
                <button type="button" class="btn btn-primary">바로 밑 추가</button>
            </div>
        </div>
    `;
    return formInit;
  }
  // 필드 추가
  function addField() {
    let fieldInit = `
            <div class="dynamic-field">
                <input class="form-control form-control-lg" type="text" />
                <button type="button" class="btn btn-primary">바로 밑 추가</button>
            </div>
    `;
    return fieldInit;
  }
  // (폼 추가) 버튼 추가
  function addFormButton() {
    let addFormButton = `
      <button type="button" class="btn btn-success">폼 추가</button>
      `;
    return addFormButton;
  }

  // 폼 검증
  function removeFormButton() {
    let removeFormButton = `
      <button type="button" class="btn btn-danger">폼 삭제</button>
      `;
    return removeFormButton;
  }

  //폼 삭제 버튼 검증
  function validateRemoveButton() {
    // 폼이 하나라면 삭제 버튼이 있으면 안된다.
    if ($(".dynamic-form").length === 1) {
      $(".btn-danger").each(function () {
        $(this).remove();
      });
    }
  }
});
