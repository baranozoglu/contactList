<template>
  <div id="app">
    <el-input placeholder="Search Name" v-model="input" clearable> </el-input>
    <Table :data="peopleList" />
    <div class="block">
      <el-pagination
        layout="prev, pager, next"
        @current-change="handleCurrentChange"
        :page-size="pageSize"
        :total="totalItems"
        :page-count="totalPages"
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
      pageSize: 10,
      page: null,
      totalItems: null,
      input: "",
    };
  },
  methods: {
    handleCurrentChange(val) {
      var thizz = this;
      this.page = val - 1;
      var header = {
        "Cache-Control": "no-cache",
        Pragma: "no-cache",
        "Axios-Call": "true",
        "Referrer-Policy": "no-referrer",
        "Access-Control-Allow-Methods": "GET",
        "Access-Control-Allow-Origin": "*",
      };
      axios
        .get(
          "http://localhost:8080/contactList/people?name=" +
            this.input +
            "&page=" +
            this.page,
          {
            headers: header,
          }
        )
        .then(function(response) {
          thizz.peopleList = response.data.peopleList;
          thizz.totalPages = response.data.totalPages;
          thizz.page = response.data.currentPage;
          thizz.totalItems = response.data.totalItems;
          console.log("this.peopleList :>> ", thizz.peopleList);
          console.log("this.totalPages :>> ", thizz.totalPages);
          console.log("this.currentPage :>> ", thizz.page);
          console.log("this.totalItems :>> ", thizz.totalItems);
        })
        .catch(function(error) {
          console.log("error :>> ", error);
        });
    },
  },
  watch: {
    input() {
      var thizz = this;
      this.page = 0;
      var header = {
        "Cache-Control": "no-cache",
        Pragma: "no-cache",
        "Axios-Call": "true",
        "Referrer-Policy": "no-referrer",
        "Access-Control-Allow-Methods": "GET",
        "Access-Control-Allow-Origin": "*",
      };
      axios
        .get(
          "http://localhost:8080/contactList/people?name=" +
            this.input +
            "&page=" +
            this.page,
          {
            headers: header,
          }
        )
        .then(function(response) {
          thizz.peopleList = response.data.peopleList;
          thizz.totalPages = response.data.totalPages;
          thizz.page = response.data.currentPage;
          thizz.totalItems = response.data.totalItems;
          console.log("this.peopleList :>> ", thizz.peopleList);
          console.log("this.totalPages :>> ", thizz.totalPages);
          console.log("this.currentPage :>> ", thizz.page);
          console.log("this.totalItems :>> ", thizz.totalItems);
        })
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
    var urlUpload = "http://localhost:8080/contactList/upload?csvName=people";
    var thizz = this;
    axios
      .get(urlUpload, { headers: header })
      .then(function(response) {
        thizz.peopleList = response.data.peopleList;
        thizz.totalPages = response.data.totalPages;
        thizz.page = response.data.currentPage;
        thizz.totalItems = response.data.totalItems;
        console.log("this.peopleList :>> ", thizz.peopleList);
        console.log("this.totalPages :>> ", thizz.totalPages);
        console.log("this.currentPage :>> ", thizz.page);
        console.log("this.totalItems :>> ", thizz.totalItems);
      })
      .catch(function(error) {
        console.log("error :>> ", error);
      });
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
