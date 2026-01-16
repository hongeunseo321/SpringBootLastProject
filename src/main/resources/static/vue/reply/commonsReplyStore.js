const {defineStore} = Pinia
const usecommonsReplyStore=defineStore('commons_reply',{
	// 공통 사용 변수 => 변경 시마다 HTML(=>mount())에 반영
	state:()=>({
		list:[],
		curpage:1,
		startPage:0,
		endPage:0,
		totalpage:0,
		cno:0,
		sessionId:'',
		msg:'',
		count:0
		
		// update 관련
	}),
	getters:{
		range:(state)=>{
			const arr=[]
			for(let i=state.startPage;i<=state.endPage;i++) {
				arr.push(i) // push(저장), pop(삭제)
			}	
			return arr
		}
	},
	actions:{
		// then(response=>{})
		setPageData(data){
			this.list=data.list
			this.curpage=data.curpage
			this.startPage=data.startPage
			this.endPage=data.endPage
			this.totalpage=data.totalpage
			this.cno=data.cno
			this.count=data.count
		},
		// prev() / next() / pageChange()
		movePage(page){
			this.curpage=page
		},
		async commonsListData(cno){
			this.cno=cno
			const res=await api.get('/commons/list_vue/', {
				params:{
					page:this.curpage,
					cno:cno
				}	
			})
			this.setPageData(res.data)
		},
		async commonsInsert(msgRef) {
			if(this.msg===''){
				msgRef?.focus()
				return
			}
			const res=await api.post('/commons/insert_vue', {
				cno:this.cno,
				msg:this.msg
			})
			this.setPageData(res.data)
		},
		// 삭제
		async commonsDelete(no){
			const res=await api.delete('/commons/delete_vue/',{
				params:{
					no:no,
					cno:this.cno,
					page:this.page
				}
			})
			this.setPageData(res.data)
		}
		
		// 수정
		
		// 대댓글
	}
})