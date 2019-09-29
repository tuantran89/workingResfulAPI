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
    	  }).then(response=>{
              if(response.ok){
            	  location.reload(); 
              }
              throw new Error('Request failed');
          	}, newtworkError => console.log(networkError.message)
    	  ).catch(err => {
    	    console.error(err)
    	  });
    } else {
        return false;
    }
}

function updateRow(btnedit){
	if (typeof(btnedit) == "object") {
		
        var editRow = $(btnedit).closest("tr");
        var id = editRow.find('.id:first').text();
        
        var work = {}
        work["name"] = editRow.find('.name:first').text();
        work["startdate"] = editRow.find('.stdate:first #startdate').val();
        work["enddate"] = editRow.find('.enddate:first #enddate').val();
        work["status"] = editRow.find('.status:first #status').val();
        
        try {
      	  const response = fetch("/work/update/" + id, {
      	    method: 'PUT', 
      	    body: JSON.stringify(work),
      	    headers: {
      	      'Content-Type': 'application/json'
      	    }
      	  }).then(response=>{
              if(response.ok){
            	  location.reload(); 
              }
              throw new Error('Request failed');
          	}, newtworkError => console.log(networkError.message)
    	  );
        } catch (error) {
      	  console.error('Error:', error);
        }
      
    } else {
        return false;
    }
}

function addWorkByResful() {

    var work = {}
    work["name"] = $("#add-form #name").val();
    work["startdate"] = $("#add-form #startdate").val();
    work["enddate"] = $("#add-form #enddate").val();
    work["status"] = $("#add-form #status").val();
    
    try {
    	  const response = fetch("/work/add", {
    	    method: 'POST', 
    	    body: JSON.stringify(work),
    	    headers: {
    	      'Content-Type': 'application/json'
    	    }
    	  }).then(response=>{
              if(response.ok){
            	  location.reload(); 
              }
              throw new Error('Request failed');
          	}, newtworkError => console.log(networkError.message)
    	  );
    } catch (error) {
    	  console.error('Error:', error);
    }
    	
   
}