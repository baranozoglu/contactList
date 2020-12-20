<template>
  <el-table :data="tableData" style="width: 100%">
    <el-table-column prop="id" label="ID" width="180"> </el-table-column>
    <el-table-column prop="name" label="Name" width="180"> </el-table-column>
    <el-table-column prop="url" label="Url"> </el-table-column>
  </el-table>
</template>

<script>
export default {
  data() {
    return {
      tableData: [
        {
          id: "1",
          name: "Tom",
          url: "No. 189, Grove St, Los Angeles",
        },
        {
          id: "1",
          name: "Tom",
          url: "No. 189, Grove St, Los Angeles",
        },
        {
          id: "1",
          name: "Tom",
          url: "No. 189, Grove St, Los Angeles",
        },
        {
          id: "1",
          name: "Tom",
          url: "No. 189, Grove St, Los Angeles",
        },
      ],
    };
  },
};
</script>
