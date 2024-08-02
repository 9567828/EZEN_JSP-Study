// 풀이

const gugudan = document.querySelector("#gugudan");

for (let dan = 0; dan <= 9; ++dan) {
	for (let gop = 2; gop <= 9; ++gop) {
		if (dan == 0) {
			const h = document.createElement("div")
			const ht = document.createTextNode(`${gop}단`)
			
			h.classList.add("dan")
			
			h.appendChild(ht)
			gugudan.appendChild(h)
		} else {
			const g = document.createElement("div");
			const t = document.createTextNode(`${gop} x ${dan} = ${dan * gop}`)
			
			g.appendChild(t)
			gugudan.appendChild(g);			
		}
	}
}