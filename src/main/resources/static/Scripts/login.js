$(document).ready(function() {
    $('input').on('input', function() {
        if ($(this).val() === '') {
            $(this).css('border-color', 'red');
        } else {
            $(this).css('border-color', 'green');
        }
    });

    $('form').on('submit', function(event) {
        let isValid = true;
        $('input').each(function() {
            if ($(this).val() === '') {
                $(this).css('border-color', 'red');
                isValid = false;
            }
        });
        if (!isValid) {
            event.preventDefault();
            alert('Por favor, complete todos los campos.');
        }
    });
});
