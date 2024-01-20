<template>
  <div>{{ dailyTrainTicket }}</div>
</template>

<script>
import { defineComponent } from 'vue';
export default defineComponent({
  name: 'order-view',
  setup() {
    const dailyTrainTicket =
      window.SessionStorage.get(window.SESSION_ORDER) || {};
    console.log('下单的车次信息', dailyTrainTicket);
    return {
      dailyTrainTicket,
    };
  },
});
</script>

<style lang="less" scoped></style>
