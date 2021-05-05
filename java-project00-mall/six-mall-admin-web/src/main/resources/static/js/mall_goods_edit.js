//KindEditor变量
var editor;

$(function () {
    //详情编辑器
    editor = KindEditor.create('textarea[id="editor"]', {
        items: ['source', '|', 'undo', 'redo', '|', 'preview', 'print', 'template', 'code', 'cut', 'copy', 'paste',
            'plainpaste', 'wordpaste', '|', 'justifyleft', 'justifycenter', 'justifyright',
            'justifyfull', 'insertorderedlist', 'insertunorderedlist', 'indent', 'outdent', 'subscript',
            'superscript', 'clearhtml', 'quickformat', 'selectall', '|', 'fullscreen', '/',
            'formatblock', 'fontname', 'fontsize', '|', 'forecolor', 'hilitecolor', 'bold',
            'italic', 'underline', 'strikethrough', 'lineheight', 'removeformat', '|', 'multiimage',
            'table', 'hr', 'emoticons', 'baidumap', 'pagebreak',
            'anchor', 'link', 'unlink'],
        uploadJson: '/admin/upload/file',
        filePostName: 'file'
    });
    // 初始化图片上传组件
    new AjaxUpload('#uploadGoodsCoverImg', {
        action: '/admin/upload/file',
        name: 'file',
        autoSubmit: true,
        responseType: "json",
        onSubmit: function (file, extension) {
            if (!(extension && /^(jpg|jpeg|png|gif)$/.test(extension.toLowerCase()))) {
                alert('只支持jpg、png、gif格式的文件！');
                return false;
            }
        },
        onComplete: function (file, r) {
            if (r != null && r.resultCode == 200) {
                $("#goodsCoverImg").attr("src", r.data);
                $("#goodsCoverImg").attr("style", "width: 128px;height: 128px;display:block;");
                return false;
            } else {
                alert("error");
            }
        }
    });
    // 如果是修改商品，则先加载商品原有信息
    var goodsId = getQueryVariable("goodsId");
    if(goodsId) {
        $.ajax({
            url: '/admin/goods/info/' + goodsId,
            type: 'GET',
            success: function (result) {
                if (result.resultCode == 200) {
                    var goodsInfo = result.data;
                    $("#goodsId").val(goodsInfo.goodsId);
                    $("#goodsName").val(goodsInfo.goodsName);
                    $("#goodsIntro").val(goodsInfo.goodsIntro);
                    $("#originalPrice").val(goodsInfo.originalPrice);
                    $("#sellingPrice").val(goodsInfo.sellingPrice);
                    $("#stockNum").val(goodsInfo.stockNum);
                    $("#tag").val(goodsInfo.tag);
                    $("#goodsSellStatusTrue").attr("checked",goodsInfo.goodsSellStatus == 0);
                    $("#goodsSellStatusFalse").attr("checked",goodsInfo.goodsSellStatus == 1);
                    editor.html(goodsInfo.goodsDetailContent);
                    $("#goodsCoverImg").attr("src",goodsInfo.goodsCoverImg);

                    // 继续加载分类
                    $.ajax({
                        url: '/admin/categories/listForSelect?categoryId=' + goodsInfo.goodsCategoryId,
                        type: 'GET',
                        success: function (result) {
                            if (result.resultCode == 200) {
                                var levelOneSelect ='';
                                var firstLevelCategories = result.data.firstLevelCategories;
                                var length1 = firstLevelCategories.length;
                                for (var i = 0; i < length1; i++) {
                                    levelOneSelect += '<option value=\"' + firstLevelCategories[i].categoryId + '\">' + firstLevelCategories[i].categoryName + '</option>';
                                }
                                $('#levelOne').html(levelOneSelect);
                                $('#levelOne').val(result.data.firstLevelSelectId);

                                var levelTwoSelect = '';
                                var secondLevelCategories = result.data.secondLevelCategories;
                                var length2 = secondLevelCategories.length;
                                for (var i = 0; i < length2; i++) {
                                    levelTwoSelect += '<option value=\"' + secondLevelCategories[i].categoryId + '\">' + secondLevelCategories[i].categoryName + '</option>';
                                }
                                $('#levelTwo').html(levelTwoSelect);
                                $('#levelTwo').val(result.data.secondLevelSelectId);

                                var levelThreeSelect = '';
                                var thirdLevelCategories = result.data.thirdLevelCategories;
                                var length3 = thirdLevelCategories.length;
                                for (var i = 0; i < length3; i++) {
                                    levelThreeSelect += '<option value=\"' + thirdLevelCategories[i].categoryId + '\">' + thirdLevelCategories[i].categoryName + '</option>';
                                }
                                $('#levelThree').html(levelThreeSelect);
                                $('#levelThree').val(result.data.thirdLevelSelectId);
                            } else {
                                swal(result.message, {
                                    icon: "error",
                                });
                            }
                        },
                        error: function () {
                            swal("操作失败", {
                                icon: "error",
                            });
                        }
                    });
                } else {
                    swal(result.message, {
                        icon: "error",
                    });
                }
            },
            error: function () {
                swal("操作失败", {
                    icon: "error",
                });
            }
        });
    } else {
        // 加载分类 - 此处设定业务场景：一级大类最多30个，先查询 1级分类
        $.ajax({
            url: '/admin/categories/listForSelect?categoryId=0',
            type: 'GET',
            success: function (result) {
                if (result.resultCode == 200) {
                    var levelOneSelect ='';
                    var firstLevelCategories = result.data.firstLevelCategories;
                    var length1 = firstLevelCategories.length;
                    for (var i = 0; i < length1; i++) {
                        levelOneSelect += '<option value=\"' + firstLevelCategories[i].categoryId + '\">' + firstLevelCategories[i].categoryName + '</option>';
                    }
                    $('#levelOne').html(levelOneSelect);
                    // 默认选择第一个
                    $('#levelOne').value(firstLevelCategories[0].categoryId).change();
                } else {
                    swal(result.message, {
                        icon: "error",
                    });
                }
            },
            error: function () {
                swal("操作失败", {
                    icon: "error",
                });
            }
        });
    }


});

$('#confirmButton').click(function () {
    var goodsName = $('#goodsName').val();
    var tag = $('#tag').val();
    var originalPrice = $('#originalPrice').val();
    var sellingPrice = $('#sellingPrice').val();
    var stockNum = $('#stockNum').val();
    var goodsIntro = $('#goodsIntro').val();
    var goodsCategoryId = $('#levelThree option:selected').val();
    var goodsSellStatus = $("input[name='goodsSellStatus']:checked").val();
    var goodsDetailContent = editor.html();
    if (isNull(goodsCategoryId)) {
        swal("请选择分类", {
            icon: "error",
        });
        return;
    }
    if (isNull(goodsName)) {
        swal("请输入商品名称", {
            icon: "error",
        });
        return;
    }
    if (!validLength(goodsName, 100)) {
        swal("请输入商品名称", {
            icon: "error",
        });
        return;
    }
    if (isNull(tag)) {
        swal("请输入商品小标签", {
            icon: "error",
        });
        return;
    }
    if (!validLength(tag, 100)) {
        swal("标签过长", {
            icon: "error",
        });
        return;
    }
    if (isNull(goodsIntro)) {
        swal("请输入商品简介", {
            icon: "error",
        });
        return;
    }
    if (!validLength(goodsIntro, 100)) {
        swal("简介过长", {
            icon: "error",
        });
        return;
    }
    if (isNull(originalPrice) || originalPrice < 1) {
        swal("请输入商品价格", {
            icon: "error",
        });
        return;
    }
    if (isNull(sellingPrice) || sellingPrice < 1) {
        swal("请输入商品售卖价", {
            icon: "error",
        });
        return;
    }
    if (isNull(stockNum) || sellingPrice < 0) {
        swal("请输入商品库存数", {
            icon: "error",
        });
        return;
    }
    if (isNull(goodsSellStatus)) {
        swal("请选择上架状态", {
            icon: "error",
        });
        return;
    }
    if (isNull(goodsDetailContent)) {
        swal("请输入商品介绍", {
            icon: "error",
        });
        return;
    }
    if (!validLength(goodsDetailContent, 50000)) {
        swal("商品介绍内容过长", {
            icon: "error",
        });
        return;
    }
    $('#goodsModal').modal('show');
});

$('#saveButton').click(function () {
    var goodsId = $('#goodsId').val();
    var goodsCategoryId = $('#levelThree option:selected').val();
    var goodsName = $('#goodsName').val();
    var tag = $('#tag').val();
    var originalPrice = $('#originalPrice').val();
    var sellingPrice = $('#sellingPrice').val();
    var goodsIntro = $('#goodsIntro').val();
    var stockNum = $('#stockNum').val();
    var goodsSellStatus = $("input[name='goodsSellStatus']:checked").val();
    var goodsDetailContent = editor.html();
    var goodsCoverImg = $('#goodsCoverImg')[0].src;
    if (isNull(goodsCoverImg) || goodsCoverImg.indexOf('img-upload') != -1) {
        swal("封面图片不能为空", {
            icon: "error",
        });
        return;
    }
    var url = '/admin/goods/save';
    var swlMessage = '保存成功';
    var data = {
        "goodsName": goodsName,
        "goodsIntro": goodsIntro,
        "goodsCategoryId": goodsCategoryId,
        "tag": tag,
        "originalPrice": originalPrice,
        "sellingPrice": sellingPrice,
        "stockNum": stockNum,
        "goodsDetailContent": goodsDetailContent,
        "goodsCoverImg": goodsCoverImg,
        "goodsCarousel": goodsCoverImg,
        "goodsSellStatus": goodsSellStatus
    };
    if (goodsId > 0) {
        url = '/admin/goods/update';
        swlMessage = '修改成功';
        data = {
            "goodsId": goodsId,
            "goodsName": goodsName,
            "goodsIntro": goodsIntro,
            "goodsCategoryId": goodsCategoryId,
            "tag": tag,
            "originalPrice": originalPrice,
            "sellingPrice": sellingPrice,
            "stockNum": stockNum,
            "goodsDetailContent": goodsDetailContent,
            "goodsCoverImg": goodsCoverImg,
            "goodsCarousel": goodsCoverImg,
            "goodsSellStatus": goodsSellStatus
        };
    }
    $.ajax({
        type: 'POST',//方法类型
        url: url,
        contentType: 'application/json',
        data: JSON.stringify(data),
        success: function (result) {
            if (result.resultCode == 200) {
                $('#goodsModal').modal('hide');
                swal({
                    title: swlMessage,
                    type: 'success',
                    showCancelButton: false,
                    confirmButtonColor: '#1baeae',
                    confirmButtonText: '返回商品列表',
                    confirmButtonClass: 'btn btn-success',
                    buttonsStyling: false
                }).then(function () {
                    window.location.href = "/mall_goods.html";
                })
            } else {
                $('#goodsModal').modal('hide');
                swal(result.message, {
                    icon: "error",
                });
            }
            ;
        },
        error: function () {
            swal("操作失败", {
                icon: "error",
            });
        }
    });
});

$('#cancelButton').click(function () {
    window.location.href = "/mall_goods.html";
});

$('#levelOne').on('change', function () {
    $.ajax({
        url: '/admin/categories/listForSelect?categoryId=' + $(this).val(),
        type: 'GET',
        success: function (result) {
            if (result.resultCode == 200) {
                var levelTwoSelect = '';
                var secondLevelCategories = result.data.secondLevelCategories;
                var length2 = secondLevelCategories.length;
                for (var i = 0; i < length2; i++) {
                    levelTwoSelect += '<option value=\"' + secondLevelCategories[i].categoryId + '\">' + secondLevelCategories[i].categoryName + '</option>';
                }
                $('#levelTwo').html(levelTwoSelect);
                // 默认选择第一个
                $('#levelTwo').value(secondLevelCategories[0].categoryId).change();
            } else {
                swal(result.message, {
                    icon: "error",
                });
            }
            ;
        },
        error: function () {
            swal("操作失败", {
                icon: "error",
            });
        }
    });
});

$('#levelTwo').on('change', function () {
    $.ajax({
        url: '/admin/categories/listForSelect?categoryId=' + $(this).val(),
        type: 'GET',
        success: function (result) {
            if (result.resultCode == 200) {
                var levelThreeSelect = '';
                var thirdLevelCategories = result.data.thirdLevelCategories;
                var length = thirdLevelCategories.length;
                for (var i = 0; i < length; i++) {
                    levelThreeSelect += '<option value=\"' + thirdLevelCategories[i].categoryId + '\">' + thirdLevelCategories[i].categoryName + '</option>';
                }
                $('#levelThree').html(levelThreeSelect);
                // 默认选择第一个
                $('#levelThree').val(thirdLevelCategories[0].categoryId);
            } else {
                swal(result.message, {
                    icon: "error",
                });
            }
            ;
        },
        error: function () {
            swal("操作失败", {
                icon: "error",
            });
        }
    });
});

