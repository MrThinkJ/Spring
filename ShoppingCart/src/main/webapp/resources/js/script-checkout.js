$(document).ready(function () {
    if ($('.text_input_name').attr('value') != null){
        if ($('.text_input_name').attr('value') != ''){
            $('.text_input_name').parent().children('label').addClass('active');
        }
    }
    if ($('.text_input_address').attr('value') != null){
        if ($('.text_input_address').attr('value') != ''){
            $('.text_input_address').parent().children('label').addClass('active');
        }
    }
    $('.text_input').on("focus", function(){
        $(this).parent().children('label').addClass('active');
    });
    $('.text_input').on("focusout", function(){
        let input = this.value;
        if (input == ''){
            $(this).parent().children('label').removeClass('active');
        }
    });
    
})