$(document).ready(function () {
    $('.delete').click(function () {
        let html = "<div class='wrapper-delete-form wrapper-form'> <div class='head-form d-flex'> <div class='title d-flex'> <div style='flex-shrink: 0; margin-right: 10px;'>Bạn có chắc muốn xóa sản phẩm này ?</div> "+
            "<input class='id-input' name='id' type='text' role='spinbutton' aria-valuenow='1' value='1' style='display: none;'> </div> </div>"+
            "<div class='main-form d-flex' style='justify-content: space-around;'> <button class='delete-btn'> Chắc chắn </button> <button onclick= dismissFunction() type='button' class='btn btn-secondary delete-btn cancel' data-bs-dismiss='modal'>Không</button> </div>"+
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
    let html = '';
    document.getElementById('delete-form').innerHTML = html;
    ($(document.getElementsByTagName('header'))).removeClass('blur');
    ($(document.getElementsByTagName('main'))).removeClass('blur');
}
function remove()
{
    ($(document.getElementsByClassName('wrapper-update-form'))).removeClass('active').addClass('out');
    ($(document.getElementsByTagName('header'))).removeClass('blur');
    ($(document.getElementsByTagName('main'))).removeClass('blur');
    ($(document.getElementsByClassName('wrapper-update-form'))).attr('style', 'display:none')
}