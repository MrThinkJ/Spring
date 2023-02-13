$(document).ready(function () {
    let count = $('.row').children('.col').length;
    let index = 5;
    while (count > 0) {
        $(document.getElementsByClassName('col')[index]).css('background-color', '#fff');
        index++;
        count--;
        if (index % 5 == 0) {
            index += 5;
            count -= 5;
        }
    }
})