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
      header: {
        "Cache-Control": "no-cache",
        Pragma: "no-cache",
        "Axios-Call": "true",
        "Referrer-Policy": "no-referrer",
        "Access-Control-Allow-Methods": "GET",
        "Access-Control-Allow-Origin": "*",
      },
    };
  },
  methods: {
    handleCurrentChange(val) {
      this.page = val - 1;
      this.people();
    },
    upload() {
      var thizz = this;
      var urlUpload = "http://localhost:8080/contactList/upload?csvName=people";
      axios
        .get(urlUpload, { headers: this.header })
        .then(function(response) {
          thizz.peopleList = response.data.peopleList;
          thizz.totalPages = response.data.totalPages;
          thizz.page = response.data.currentPage;
          thizz.totalItems = response.data.totalItems;
        })
        .catch(function(error) {
          console.log("error :>> ", error);
        });
    },
    people() {
      var thizz = this;
      var url =
        "http://localhost:8080/contactList/people?name=" +
        this.input +
        "&page=" +
        this.page;
      axios
        .get(url, {
          headers: this.header,
        })
        .then(function(response) {
          thizz.peopleList = response.data.peopleList;
          thizz.totalPages = response.data.totalPages;
          thizz.page = response.data.currentPage;
          thizz.totalItems = response.data.totalItems;
        })
        .catch(function(error) {
          console.log("error :>> ", error);
        });
    },
  },
  watch: {
    input() {
      this.page = 0;
      this.people();
    },
  },
  mounted() {
    this.upload();
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
