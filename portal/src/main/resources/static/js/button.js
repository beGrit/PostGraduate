export default Vue.extend({
    data() {
        return {
            message: "button message",
            count: 1,
        }
    },
    template: '<button v-on:click="count++">You clicked me {{ count }} times.</button>'
});