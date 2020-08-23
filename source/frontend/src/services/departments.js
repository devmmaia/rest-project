import { http } from './config'

export default {

    list: ()=>{
        return http.get('departments')
    },
    save: (department) =>{
       return http.post('departments', department)
    },
    update:(department)=>{
        return http.put('departments/' + department.id, department)
    },
    delete:(department)=>{
        return http.delete('departments/' + department.id)
    },

}