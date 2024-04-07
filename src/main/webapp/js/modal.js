const excbtn= document.querySelectorAll(".excbtn")
excbtn.forEach(btn=>{
	btn.addEventListener("click", (event)=>{
		const modalbtn = document.querySelector(".modal-exc") ;
		const modaltxt = document.querySelector(".modal-body");
		const btnvalue = btn.getAttribute("value")
		modalbtn.href=btn.href
		modaltxt.textContent="Você deseja deletar o brinquedo com o Id "+btnvalue
	})
	
})