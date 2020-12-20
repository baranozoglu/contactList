<template>
  <div id="app">
    <el-input placeholder="Search Name" v-model="input" clearable> </el-input>
    <Table :data="peopleList" />
    <div class="block">
      <el-pagination
        layout="prev, pager, next"
        @current-change="handleCurrentChange"
        :page-size="pageSize"
        :total="totalSize"
      >
      </el-pagination>
    </div>
  </div>
</template>

<script>
import Table from "./components/Table/Table";
import axios from "axios";

export default {
  name: "App",
  components: {
    Table,
  },
  data() {
    return {
      data: [],
      peopleList: [],
      pageSize: null,
      page: null,
      totalSize: null,
      input: null,
    };
  },
  methods: {
    handleCurrentChange(val) {
      this.page = val;
    },
  },
  watch: {
    input() {
      console.log("this.input :>> ", this.input);
      var header = {
        "Cache-Control": "no-cache",
        Pragma: "no-cache",
        "Axios-Call": "true",
        "Referrer-Policy": "no-referrer",
        "Access-Control-Allow-Methods": "GET",
        "Access-Control-Allow-Origin": "*",
      };
      axios
        .get("http://localhost:8080/contactList/people?name=" + this.input, {
          headers: header,
        })
        .then((response) => (this.peopleList = response.data.peopleList))
        .catch(function(error) {
          console.log("error :>> ", error);
        });
    },
  },
  mounted() {
    var header = {
      "Cache-Control": "no-cache",
      Pragma: "no-cache",
      "Axios-Call": "true",
      "Referrer-Policy": "no-referrer",
      "Access-Control-Allow-Methods": "GET",
      "Access-Control-Allow-Origin": "*",
    };
    // var paramsUpload = {
    //   csvName: "people",
    // };
    // var paramsPeople = {
    //   name: "",
    //   page: null,
    //   size: null,
    // };
    var urlUpload = "http://localhost:8080/contactList/upload?csvName=people";
    //var urlPeople = "http://localhost:8080/contactList/people";

    axios
      .get(urlUpload, { headers: header })
      .then((response) => (this.peopleList = response.data.peopleList))
      .catch(function(error) {
        console.log("error :>> ", error);
      });
    // this.peopleList = response.data.peopleList;
    // this.pageSize = response.data.totalPages;
    // this.currentPage = response.data.currentPage;
    // this.totalSize = response.data.totalSize;
    // console.log("this.peopleList :>> ", this.peopleList);
    // console.log("this.pageSize :>> ", this.pageSize);
    // console.log("this.currentPage :>> ", this.currentPage);
    // console.log("this.totalSize :>> ", this.totalSize);
    // axios({
    //   url: url,
    //   method: "GET",
    //   data: params,
    //   headers: header,
    // }).then((response) => (this.info = response.data.peopleList));
    // axios
    //     .get("http://localhost:8080/contactList/upload", config, params)
    //     .then((response) => (this.info = response))
    //     .then(
    //       axios
    //         .get("http://localhost:8080/contactList/people")
    //         .then((response) => (this.info = response.data.peopleList))
    //     );
  },
};
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
