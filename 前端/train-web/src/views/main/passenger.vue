<template>
  <div class="operateButton">
    <a-button type="primary" @click="onAdd">新增</a-button>
  </div>

  <a-modal
    v-model:visible="visible"
    title="乘车人"
    @ok="handleOk"
    ok-text="确认"
    cancel-text="取消"
  >
    <a-form
      :model="passenger"
      :label-col="{ span: 4 }"
      :wrapper-col="{ span: 20 }"
    >
      <a-form-item label="姓名">
        <a-input v-model:value="passenger.name" />
      </a-form-item>
      <a-form-item label="身份证">
        <a-input v-model:value="passenger.idCard" />
      </a-form-item>
      <a-form-item label="旅客类型">
        <a-select v-model:value="passenger.type">
          <a-select-option
            v-for="item in PASSENGER_TYPE_ARRAY"
            :key="item.code"
            :value="item.code"
          >
            {{ item.desc }}
          </a-select-option>
        </a-select>
      </a-form-item>
    </a-form>
  </a-modal>
</template>

<script>
import { defineComponent, ref } from 'vue';
import { notification } from 'ant-design-vue';
import axios from 'axios';

export default defineComponent({
  name: 'passenger-view',
  setup() {
    const PASSENGER_TYPE_ARRAY = ref([
      { desc: '成人', code: 1 },
      { desc: '儿童', code: 2 },
      { desc: '学生', code: 3 },
    ]);
    const visible = ref(false);
    const passenger = ref({
      id: undefined,
      memberId: undefined,
      name: undefined,
      idCard: undefined,
      type: undefined,
      createTime: undefined,
      updateTime: undefined,
    });

    const onAdd = () => {
      passenger.value = {};
      visible.value = true;
    };

    const handleOk = () => {
      axios.post('/member/passenger/save', passenger.value).then(response => {
        const data = response.data;
        if (data.success) {
          notification.success({ description: '保存成功！' });
          visible.value = false;
        } else {
          notification.error({ description: data.message });
        }
      });
    };
    return {
      PASSENGER_TYPE_ARRAY,
      passenger,
      visible,
      onAdd,
      handleOk,
    };
  },
});
</script>
<style lang="less" scoped>
.operateButton {
  display: flex;
}
</style>
