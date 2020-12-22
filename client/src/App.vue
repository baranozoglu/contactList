<template>
  <el-row>
    <el-col :xs="{ span: 24 }" :md="{ span: 12, offset: 6 }">
      <h1 style="text-align: center">Contact List</h1>
      <el-input placeholder="Search Name" v-model="input" clearable> </el-input>
    </el-col>
    <el-col :xs="{ span: 24 }" :md="{ span: 12, offset: 6 }">
      <div id="app">
        <Table :data="peopleList" />
      </div>
    </el-col>
    <el-col :xs="{ span: 24 }" :md="{ span: 12, offset: 6 }">
      <div class="block" text-align="center">
        <el-pagination
          id="pagination"
          layout="prev, pager, next"
          @current-change="handleCurrentChange"
          :page-size="pageSize"
          :total="totalItems"
          :page-count="totalPages"
        >
        </el-pagination>
      </div>
    </el-col>
  </el-row>
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
      page: 0,
      totalItems: null,
      totalPages: null,
      input: "",
      header: {
        "Cache-Control": "no-cache",
        Pragma: "no-cache",
        "Axios-Call": "true",
        "Referrer-Policy": "no-referrer",
      },
    };
  },
  methods: {
    handleCurrentChange(val) {
      this.page = val - 1;
      this.people();
    },
    people() {
      var thizz = this;
      var url =
        "http://localhost:8080/contactList/people"
      axios
        .get(url, {
          headers: this.header, params: {name: this.input, page: this.page}
        })
        .then(function(response) {
          thizz.peopleList = response.data.dataList;
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
    this.people();
  },
};
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  color: #2c3e50;
  margin-top: 60px;
}
#pagination {
  text-align: center;
}
body {
  background-color: rgb(240, 238, 238);
}
</style>
