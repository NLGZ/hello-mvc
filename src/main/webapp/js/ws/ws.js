/**
 * 웹소켓 작성
 * - endpoint(/echo)로 최초 웹소켓 연결요청
 */
const ws = new WebSocket(`ws://${location.host}${contextPath}/echo`);

/**
 * 핸들러 바인딩
 */
ws.addEventListener('open', (e) => {
   console.log('open', e);
});
ws.addEventListener('message', (e) => {
   console.log('message', e);
});
ws.addEventListener('error', (e) => {
   console.log('error', e);
});
ws.addEventListener('close', (e) => {
   console.log('close', e); 
});
