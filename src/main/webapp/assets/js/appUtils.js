class AppUtils {

    static BASE_API_URL = 'http://localhost:8082/api'
    static BASE_CUSTOMER_API = this.BASE_API_URL + '/customers'

    static showSuccess = (text) => {
        $.toast({
            heading: 'Success',
            text: text,
            showHideTransition: 'slide',
            icon: 'success',
            position: 'top-right',
        })
    }

    static showError = (text) => {
        $.toast({
            heading: 'Error',
            text: text,
            showHideTransition: 'fade',
            icon: 'error',
            position: 'top-right',
        })
    }
}