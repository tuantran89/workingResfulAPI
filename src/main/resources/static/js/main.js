$(document).ready(function () {

	$('#work_table').DataTable();
    $("#add-form").submit(function (event) {

        event.preventDefault();
        addWorkByResful();

    });

});

function deleteRow(btndel){
	if (typeof(btndel) == "object") {
        var id = $(btndel).closest("tr").find('.id:first').text();
        fetch("/work/delete/" + id, {
    	    method: 'DELETE'
    	  }).then(() => {
    	     console.log('removed');
    	  }).catch(err => {
    	    console.error(err)
    	  });
    } else {
        return false;
    }
}

function addWorkByResful() {

    var work = {}
    work["name"] = $("#name").val();
    work["startdate"] = $("#startdate").val();
    work["enddate"] = $("#enddate").val();
    work["status"] = $("#status").val();
    
    try {
    	  const response = fetch("/work/add", {
    	    method: 'POST', 
    	    body: JSON.stringify(work),
    	    headers: {
    	      'Content-Type': 'application/json'
    	    }
    	  });
    } catch (error) {
    	  console.error('Error:', error);
    }
    	
   
}