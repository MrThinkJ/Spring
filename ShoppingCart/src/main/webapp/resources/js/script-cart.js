$(document).ready(function () {
    let count = $('.row').children('.col').length;
    let index = 4;
    while (count > 0) {
        $(document.getElementsByClassName('col')[index]).css('background-color', '#fff');
        index++;
        count--;
        if (index % 4 == 0) {
            index += 4;
            count -= 4;
        }
    }
})