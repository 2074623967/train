<template>
  <div class="order-train">
    <span class="order-train-main">{{ dailyTrainTicket.date }}</span
    >&nbsp;
    <span class="order-train-main">{{ dailyTrainTicket.trainCode }}</span
    >次&nbsp; <span class="order-train-main">{{ dailyTrainTicket.start }}</span
    >站
    <span class="order-train-main">({{ dailyTrainTicket.startTime }})</span
    >&nbsp; <span class="order-train-main">——</span>&nbsp;
    <span class="order-train-main">{{ dailyTrainTicket.end }}</span
    >站
    <span class="order-train-main">({{ dailyTrainTicket.endTime }})</span>&nbsp;
  </div>
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

<style lang="less" scoped>
.order-train .order-train-main {
  font-size: 18px;
  font-weight: bold;
}
</style>
