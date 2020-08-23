<template>
  <div id="app">
    <nav>
      <div class="nav-wrapper blue darken-1">
        <a href="#" class="brand-logo center">Cadastro de Departamentos</a>
      </div>
    </nav>

    <div class="container">
      <form @submit.prevent="btnSave">
        <p v-for="message of successMessages" :key="message">{{message}}</p>
        <label>Código</label>
        <input type="text" placeholder="Código" v-model="department.code" />
        <label>Nome</label>
        <input type="text" placeholder="Nome" v-model="department.name" />
        <label>Local</label>
        <input type="text" placeholder="Local" v-model="department.location" />
        <label>Cidade</label>
        <input type="text" placeholder="Cidade" v-model="department.city" />
        <label>Estado</label>

        <select name="estado" v-model="department.state" class="browser-default">
          <option value>Selecione</option>
          <option value="ac">Acre</option>
          <option value="al">Alagoas</option>
          <option value="ap">Amapá</option>
          <option value="am">Amazonas</option>
          <option value="ba">Bahia</option>
          <option value="ce">Ceará</option>
          <option value="df">Distrito Federal</option>
          <option value="es">Espírito Santo</option>
          <option value="go">Goiás</option>
          <option value="ma">Maranhão</option>
          <option value="mt">Mato Grosso</option>
          <option value="ms">Mato Grosso do Sul</option>
          <option value="mg">Minas Gerais</option>
          <option value="pa">Pará</option>
          <option value="pb">Paraíba</option>
          <option value="pi">Piauí</option>
          <option value="rj">Rio de Janeiro</option>
          <option value="rn">Rio Grande do Norte</option>
          <option value="rs">Rio Grande do Sul</option>
          <option value="ro">Rondônia</option>
          <option value="rr">Roraima</option>
          <option value="sc">Santa Catarina</option>
          <option value="sp">São Paulo</option>
          <option value="se">Sergipe</option>
          <option value="to">Tocantins</option>
        </select>
        <br />
        <label for>Diretoria</label>
        <p>
          <label>
            <input name="group1" type="radio" value="1" v-model="department.board" />
            <span>E.I.S</span>
          </label>
        </p>
        <p>
          <label>
            <input name="group1" type="radio" value="2" v-model="department.board" />
            <span>Recuperação</span>
          </label>
        </p>
        <p>
          <label>
            <input name="group1" type="radio" value="3" v-model="department.board" />
            <span>Negócios</span>
          </label>
        </p>

        <br />
        <button class="waves-effect waves-light btn-small">
          Gravar
          <i class="material-icons left">save</i>
        </button>
      </form>

      <table>
        <thead>
          <tr>
            <th>Código</th>
            <th>Nome</th>
            <th>Ações</th>
          </tr>
        </thead>

        <tbody>
          <tr v-for="dpto of departments" :key="dpto.id">
            <td>{{dpto.code}}</td>
            <td>{{dpto.name}}</td>

            <td>
              <button class="waves-effect btn-small blue darken-1" @click="btnEdit(dpto)">
                <i class="material-icons">create</i>
              </button>
              <button class="waves-effect btn-small red darken-1" @click="btnDelete(dpto)">
                <i class="material-icons">delete_sweep</i>
              </button>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
  </div>
</template>

 <script>
import Department from "./services/departments";
export default {
  data() {
    return {
      departments: [],
      department: {
        id: "",
        code: "",
        name: "",
        location: "",
        city: "",
        state: "",
        board: "",
      },
      successMessages: [],
      errorMessages: [],
    };
  },
  mounted() {
    this.list();
  },

  methods: {
    clear() {
      this.department = {};
      this.errorMessages = [];
      this.successMessages = [];
    },
    save() {
      Department.save(this.department)
        .then(() => {
          this.list();
          this.clear();
          this.successMessages = ["Salvo com sucesso"];
        })
        .catch((e) => {
          console.log(e.data);
        });
    },
    edit() {
      Department.update(this.department)
        .then(() => {
          this.list();
          this.clear();
          this.successMessages = ["Salvo com sucesso"];
        })
        .catch((e) => {
          console.log(e.data);
        });
    },

    btnSave() {
      if (!this.department.id) {
        this.save();
      } else {
        this.edit();
      }
    },
    btnEdit(department) {
      this.department = department;
    },
    btnDelete(department) {
      Department.delete(department)
        .then(() => {
          this.list();
          this.clear();
          this.successMessages = ["Removido com sucesso"];
        })
        .catch((e) => {
          console.log(e.data);
        });
    },
    list() {
      Department.list().then((response) => {
        this.departments = response.data.result;
      });
    },
  },
};
</script>


<style scoped>
</style>