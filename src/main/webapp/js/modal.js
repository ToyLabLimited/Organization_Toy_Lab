const excbtn= document.querySelectorAll(".excbtn")
excbtn.forEach(btn=>{
	btn.addEventListener("click", (event)=>{
		const modalbtn = document.querySelector(".modal-exc") ;
		modalbtn.href=btn.href
	})
	
})