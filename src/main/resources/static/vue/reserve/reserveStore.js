const {defineStore} = Pinia

const useReserveStore=defineStore('reserve',{
	state:()=>({
		loc_list:[
		  "강남구","강동구","강북구","강서구",
		  "관악구","광진구","구로구","금천구",
		  "노원구","도봉구","동대문구","동작구",
		  "마포구","서대문구","서초구","성동구",
		  "성북구","송파구","양천구","영등포구",
		  "용산구","은평구","종로구","중구","중랑구"
		],
		no:0,
		loc:'all',
		curpage:1,
		totalpage:0,
		food_list:[],
		image:'data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAANcAAACUCAMAAAA3b0xFAAAAGFBMVEX4+Pjg4ODj4+P09PTt7e3p6enw8PDm5ubULvjhAAADIklEQVR4nO2c4ZKrIAxGFQK8/xuvAkbA4O26vSNhvvPTtjucJoSgdJcFAAAAAAAAAAAAAAAAAAAAAAAA0If19u0h/A/IrKt7exDfh9YdensY3yZpTRewPQknjNehZeaqHKzl3x7Jp9gW6U3atCy50OAcXQavTcuHVcJQHTR1WkbU2gilmDYt29WqVil1Wq6vta4swVpaFi6fhuuoIVSZSMecGzxaXMlzFl6jYEPxAmsNHS0fzE6MRcpCJyxXqZxEER1a9ijrgbNQzC7SpVXU9WUpk61l809aSiohsVeuhaHTxKaOQ4WWpW1ucRU3Hwz4/BbinHRD2tEqcLtFpMuq3Yvui4hL8O04xR5rNDExWrc7RLl1HGxTKTaCt0nY64jHqvc5XNvWiml2Iov1vrg3yFrnR8x4mZiW4/5ssmeJSO0Ha5XhGe8umzV3I6ra+picrFVV9vTtDOUVp3xn+alKSq3VODhNXp9rafI6czC2FPulrpYmL+7Xnc/bMt/fHevxootDP1qKvPJyHYR1S7UXtVpFXyK8XYtXsjCiltRmafFqG4hDy7S+GSVebXfF0aIkfPketHjV3RVruV7HpMWrunpq2Zyhof0zSrx8mYZnEu4XqKmTCYVefGMxVUESC4c+r0ZrAq8o0mrpz8M4dtbiMTtxYVbitZWKWotFlNf50NHKjyS0rsuL7WilS2r7qPTSVSv3jXr73kUqGcceTLizq8dLipa/iB6o8SofXx7kS9KNeC1etjhsQ3sRsXz8RkxaLV7yGaJ+jVHi9VstJV6cchet3gMKFV5cMqytA9c/0qDBK5SxsS4ct2zCzbgVePG6daSc9UT0j0P/43tV0fqY4b2eaQ3v9VBrQK9YFY4e8KmWv32a+wrp6V0MGD/JM3Q5YH5L7rGGOkwUe3STSjqvU78kf2qkcw6xw220HjJUGu5z4ztaw/2WyO/z4u9aQ2XhwR+1zJgHEE+t0B4s/wg/plWhNWQyPQVaqoCWJqClCe7gJ9UadGF9yKRJ6OeM1jKp1jKpVj5iMp1WrBuTlYyM/I8MAAAAAAAAAAAAAAAAAADQ4wcBqxWP5PkCiwAAAABJRU5ErkJggg==',
		title:'',
		day:'',
		time:'',
		inwon:'',
		isDate:true,
		isTime:false,
		isInwon:false,
		isReserveBtn:false,
		
		time_list:[], // 랜덤 
		inwon_list:[
			"2명","3명","4명","5명","6명","7명","8명","9명","단체"
		]
		
	}),
	actions:{
		async dataRecv(){
			const res=await api.get(
				'/reserve/food_list_vue/',{
					params:{
						page:this.curpage,
						address:this.loc
					}
				}
			)
			this.food_list=res.data.list
			this.loc=res.data.address
			this.curpage=res.data.curpage
			this.totalpage=res.data.totalpage
		},
		dateSelect(day){
			this.day=day
		},
		prev(){
			this.curpage=this.curpage>1?this.curpage-1:this.curpage
			this.dataRecv()
		},
		next(){
			this.curpage=this.curpage<this.totalpage?this.curpage+1:this.curpage
			this.dataRecv()	
		},
		locChange(){
			this.curpage=1
			this.dataRecv()
		},
		foodSelect(no,title,poster){
			this.no=no
			this.title=title
			this.image=poster
			this.isDate=true
		},
		timeSelect(time){
			this.time=time
			this.isInwon=true
		},
		inwonSelect(inwon){
			this.inwon=inwon
			this.isReserveBtn=true
		},
		async timeListData(){
			const res = await api.get("/reserve/time_list_vue/")
			this.time_list=res.data.list
			//this.isInwon=true
		},
		// 예약 
		async reserveInsert(){
			const res = await api.post('/reserve/insert_vue/',{
				cno:this.no,
				rday:this.day,
				rtime:this.time,
				rinwon:this.inwon
			})
			console.log(res.data)
			if(res.data==='YES')
			{
				location.href="/mypage/mypage_reserve"
			}
			else
			{
				alert("예약 실패입니다.")
				this.title=''
				this.image='data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAANcAAACUCAMAAAA3b0xFAAAAGFBMVEX4+Pjg4ODj4+P09PTt7e3p6enw8PDm5ubULvjhAAADIklEQVR4nO2c4ZKrIAxGFQK8/xuvAkbA4O26vSNhvvPTtjucJoSgdJcFAAAAAAAAAAAAAAAAAAAAAAAA0If19u0h/A/IrKt7exDfh9YdensY3yZpTRewPQknjNehZeaqHKzl3x7Jp9gW6U3atCy50OAcXQavTcuHVcJQHTR1WkbU2gilmDYt29WqVil1Wq6vta4swVpaFi6fhuuoIVSZSMecGzxaXMlzFl6jYEPxAmsNHS0fzE6MRcpCJyxXqZxEER1a9ijrgbNQzC7SpVXU9WUpk61l809aSiohsVeuhaHTxKaOQ4WWpW1ucRU3Hwz4/BbinHRD2tEqcLtFpMuq3Yvui4hL8O04xR5rNDExWrc7RLl1HGxTKTaCt0nY64jHqvc5XNvWiml2Iov1vrg3yFrnR8x4mZiW4/5ssmeJSO0Ha5XhGe8umzV3I6ra+picrFVV9vTtDOUVp3xn+alKSq3VODhNXp9rafI6czC2FPulrpYmL+7Xnc/bMt/fHevxootDP1qKvPJyHYR1S7UXtVpFXyK8XYtXsjCiltRmafFqG4hDy7S+GSVebXfF0aIkfPketHjV3RVruV7HpMWrunpq2Zyhof0zSrx8mYZnEu4XqKmTCYVefGMxVUESC4c+r0ZrAq8o0mrpz8M4dtbiMTtxYVbitZWKWotFlNf50NHKjyS0rsuL7WilS2r7qPTSVSv3jXr73kUqGcceTLizq8dLipa/iB6o8SofXx7kS9KNeC1etjhsQ3sRsXz8RkxaLV7yGaJ+jVHi9VstJV6cchet3gMKFV5cMqytA9c/0qDBK5SxsS4ct2zCzbgVePG6daSc9UT0j0P/43tV0fqY4b2eaQ3v9VBrQK9YFY4e8KmWv32a+wrp6V0MGD/JM3Q5YH5L7rGGOkwUe3STSjqvU78kf2qkcw6xw220HjJUGu5z4ztaw/2WyO/z4u9aQ2XhwR+1zJgHEE+t0B4s/wg/plWhNWQyPQVaqoCWJqClCe7gJ9UadGF9yKRJ6OeM1jKp1jKpVj5iMp1WrBuTlYyM/I8MAAAAAAAAAAAAAAAAAADQ4wcBqxWP5PkCiwAAAABJRU5ErkJggg=='
				this.time=''
				this.inwon=''
				this.isDate=false
				this.isTime=false
				this.isInwon=false
				this.isReserveBtn=false
			}
		}
		 
	}
})