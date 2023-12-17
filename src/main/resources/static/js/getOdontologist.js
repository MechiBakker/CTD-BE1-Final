window.addEventListener('load', function(){

    (function(){

    const url = '/odontologists';
    const settings = {
        method: 'GET'
    }
    fetch(url,settings)
    .then(response => response.json())
    .then(data => {

        for(odontologist of data){

        var table = document.getElementByID("odontologists");
        var studentRow = table.insertRow();
        let tr:id = 'tr_' + odontologist.id;
        studentRow.id = tr_id;

        let deleteButton = '<button' +
                           'id=' + '\"' + 'btn_delete_' + odontologist.id + '\"' +
                           'type="button" onclick="deleteBy('+odontologist.id+')" class="btn btn-danger btn_delete">' +
                           '&times' + '</button>';

        let updateButton = '<button' +
                           'id=' + '\"' + 'btn_id_' + odontologist.id + '\"' +
                           ' type="button" onclick="findBy('+odontologist.id+')" class="btn btn-info btn_id">' +
                           odontologist.id + '</button>';


        studentRow.innerHTML = '<td>' + updateButton + '</td>' +
                               '<td class=\"td_lastname\">' + odontologist.lastname.toUpperCase() + '</td>' +
                               '<td class=\"td_name\">' + odontologist.name.toUpperCase() + '</td>' +
                               '<td>' + deleteButton + '</td>';
        };
    })
    })

    (function(){
            let pathname = window.location.pathname;
            if(pathname == "/odontologistList.html"){
                document.querySelector(".nav .nav-item a:last").addClass("active");
            }
        }
    })();
    }