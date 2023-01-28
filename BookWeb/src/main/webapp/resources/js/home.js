$(document).ready(function () {
    $('.add').click(function(){
        $('#add-form').attr('action', 'add');
        $(document.getElementsByClassName('add-form')).css('display', 'block');
        ($(document.getElementsByClassName('add-form'))).addClass('active');
        ($(document.getElementsByTagName('header'))).addClass('blur');
        ($(document.getElementsByTagName('main'))).addClass('blur');
    })
    $('.update').click(function () {
        $('#update-form').attr('action', 'update');
        $(document.getElementsByClassName('update-form')).css('display', 'block');
        ($(document.getElementsByClassName('update-form'))).addClass('active');
        ($(document.getElementsByTagName('header'))).addClass('blur');
        ($(document.getElementsByTagName('main'))).addClass('blur');
        let id = $(this).parent().find('input').attr('value');
        $('.id-input').attr('value', id);
        $('.id-detail').attr('value', id);
        let name = $('.col_'+id+' #name').text();
        let author = $('.col_'+id+' #author').text();
        let isbn = $('.col_'+id+' #isbn').text();
        let price = $('.col_'+id+' #price').text();
        let publishDate = $('.col_'+id+' #publish-date').text();
        let category = $('.col_'+id+' #category').text();
        let numberOfPage = $('.col_'+id+' #number-of-page').text();
        $('#update-form .name').attr('value',name);
        $('#update-form .author').attr('value',author);
        $('#update-form .isbn').attr('value',isbn);
        $('#update-form .publish-date').attr('value',publishDate);
        $('#update-form .price').attr('value',price);
        $('#update-form .number-of-pages').attr('value',price);
        $('#update-form .category').attr('value',category);
    })
    $('.delete').click(function () {
        let html = "<div class='wrapper-delete-form wrapper-form'> <div class='head-form d-flex'> <div class='title d-flex'> <div style='flex-shrink: 0; margin-right: 10px;'>Bạn có chắc muốn xóa sản phẩm này ?</div> "+
            "<input class='id-input' name='id' type='text' role='spinbutton' aria-valuenow='1' value='1' style='display: none;'> </div> </div>"+
            "<div class='main-form d-flex' style='justify-content: space-around;'> <button class='delete-btn'> Chắc chắn </button> <button onclick= 'remove()' type='button' class='btn btn-secondary delete-btn cancel' data-bs-dismiss='modal'>Không</button> </div>"+
            "</div>";
        document.getElementById('delete-form').innerHTML = html;
        $('#delete-form').attr('action', 'delete');
        $(document.getElementsByClassName('wrapper-delete-form')).css('display', 'block');
        ($(document.getElementsByClassName('wrapper-delete-form'))).addClass('active');
        ($(document.getElementsByTagName('header'))).addClass('blur');
        ($(document.getElementsByTagName('main'))).addClass('blur');
        let id = $(this).parent().find('input').attr('value');
        $('.id-input').attr('value', id);
    })
    let count = $('.row').children('.col').length+1;
    let index = 8;
    let indexSm = 1;
    while (count > 0) {
        $(document.getElementsByClassName('col')[index]).css('background-color', '#fff');
        $(document.getElementsByClassName('col-sm')[indexSm]).css('background-color', '#fff');
        index++;
        count--;
        if (index % 8 == 0) {
            index += 8;
            count -= 8;
        }
    }
})
function dismissFunction(){
    let html = "";
    document.getElementById('update-form').innerHTML = html;
    ($(document.getElementsByClassName('wrapper-update-form'))).removeClass('active').addClass('out');
    ($(document.getElementsByTagName('header'))).removeClass('blur');
    ($(document.getElementsByTagName('main'))).removeClass('blur');
}
function remove(classname)
{
    let html = "";
    document.getElementById(classname+'-form').innerHTML = html;
    ($(document.getElementsByClassName('wrapper-'+classname+'-form'))).removeClass('active').addClass('out');
    ($(document.getElementsByTagName('header'))).removeClass('blur');
    ($(document.getElementsByTagName('main'))).removeClass('blur');
}