window.addEventListener('load', function() {

    const form = document.querySelector('#upadate_odontologist_form');
    form.addEventListener('submit', function(event) {

        const formData = {
            id: document.querySelector('#odontologist_id').value,
            lastname: document.querySelector('#lastname').value,
            name: document.querySelector('#name').value,

        };

        const url = '/odontologists';
        const settings = {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(formData)
        }
        fetch(url,settings)
        .then(response => response.json))

    })
})


    function findBy(id) {
        const url = '/odontologists'+"/"+id;
        const settings = {
            method: 'GET'
        }
        fetch(url,settings)
        .then(response => response.json())
        .then(data => {
            let estudiante = data;
            document.querySelector('#odontologist_id').value = odontologist.id;
            document.querySelector('#lastname').value = odontologist.lastname;
            document.querySelector('#name').value = odontologist.name;

            document.querySelector('#div_odontologist_updating').style.display = "block";
        }).catch(error => {
            alert("Error: " + error);

        })
    }