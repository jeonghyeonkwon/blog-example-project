$(document).ready(function () {
  $(document).on("click", ".add-row", function () {
    let rows = $(".poi-row");
    rows.last().after(addRowInit(rows.length + 1));
  });

  $(document).on("click", ".excel-down", function () {
    let inputs = $('input[type="text"]');
    inputs.each(function () {
      let value = $(this).val();
      if (value === "") {
        alert("빈 값을 채워 주세요");
        return false;
      }
    });

    let titleMap = new Map();
    let dataList = new Array();
    $("thead")
      .find('input[type="text"]')
      .each(function (index, data) {
        titleMap.set(index, $(this).val());
      });

    $(".poi-row").each(function (index, data) {
      $(this)
        .find('input[type="text"]')
        .each(function (i) {
          let obj = new Object();
          let headTitle = titleMap.get(i);
          let value = $(this).val();
          obj.title = headTitle;
          obj.value = value;
          dataList.push(obj);
        });
    });

    let data = {
      titleList: [...titleMap.values()],
      dataList: dataList,
    };
    $.ajax({
      url: "/api/poi/download",
      type: "POST",
      contentType: "application/json",
      data: JSON.stringify(data),
      success: function (res) {},
      error: function (err) {},
    });
  });

  function addRowInit(num) {
    const initRow = `
        <tr class='poi-row'>
        <th scope="row">${num}</th>
        <td>
          <input class="form-control form-control-lg" type="text" />
        </td>
        <td>
          <input class="form-control form-control-lg" type="text" />
        </td>
        <td>
          <input class="form-control form-control-lg" type="text" />
        </td>
      </tr>
        `;
    return initRow;
  }
});
