window.addEventListener('load', function(){

    const form = document.querySelector('#add_new_odontologist');

    form.addEventListener('submit', function(event){
    const formData = {
     lastname: document.querySelector('#lastname').value,
     name: document.querySelector('#name').value,
     license: document.querySelector('#license').value,

    };

    const url = '/odontologist';
    const settings = {
        method: 'POST',
        headers: {
        'Content-Type': 'application/json',
        },
        body: JSON.stringify(formData)

    }

    fetch(url, settings)
        .then(response => response.json())
        .then(data => {
            let successAlert = '<div class="alert alert success alert-dismissible">' +
                            '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                            '<strong></strong> "The odontrologist has been correctly entered" </div>'

            document.querySelector('#response').innerHTML = successAlert;
            document.querySelector('#response').style.display = "block";

            resetUploadForm();

        })
        .catch(error => {
            let errorAlert = '<div class="alert alert-danger alert-dismissible">' +
                            '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                            '<strong> "It has been an error, please try again" </strong></div>'

            document.querySelector('#response').innerHTML = errorAlert;
            document.querySelector('#response').style.display = "block";

            resetUploadForm();})
    });

    function resetUploadForm(){
    document.querySelector('#lastname').value = "";
    document.querySelector('#name').value = "";
    document.querySelector('#license').value = "";

    }

    (function(){
        let pathname = window.location.pathname;
        if(pathname === "/"){
            document.querySelector(".nav .nav-item a:first").addClass("active");
        } else if (pathname == "/odontologistList.html"){
            document.querySelector(".nav .nav-item a:list").addClass("active");
        }
    }
})();