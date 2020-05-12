// import router from './router'
// import store from './store'
// import { Message } from 'element-ui'
// import NProgress from 'nprogress' // progress bar
// import 'nprogress/nprogress.css' // progress bar style
// import { getToken } from '@/utils/auth' // get token from cookie
// import getPageTitle from '@/utils/get-page-title'
//
// // NProgress.configure({ showSpinner: false }) // NProgress Configuration
//
// // permission judge function
// function hasPermission (router, accessMenu) {
//   if (whiteList.indexOf(router.path) !== -1) {
//     return true;
//   }
//   let menu = Util.getMenuByName(router.name, accessMenu);
//   if (menu.name) {
//     return true;
//   }
//   return false;
//
// }
//
// const whiteList = ['/login', '404'] //  白名单路由
// // 路由处理--登录验证
// router.beforeEach(async (to, from, next) => {
//   // 开始进度条
//   // NProgress.start()
//
//   // 设置页面标题
//   document.title = getPageTitle(to.meta.title)
//   console.log('t', to);
//   console.log(from);
//   console.log('n', next);
//   const hasToken = getToken()
//   // 判断是否登录时，因为页面刷新后内存中还没有token信息，额外从session中判断一次
//   if (hasToken) {
//     if (to.path === '/login') {
//       // 已经登录的，不能跳到登陆页面，跳到首页
//       next({ path: '/' })
//       // NProgress.done()
//       // next({ path: '/timetask/index' })
//     } else {
//       const hasGetUserInfo = store.getters.name
//       if (hasGetUserInfo) {
//         next()
//       } else {
//         let userInfo = store.state.user.name
//         if (!userInfo) {
//           try {
//             // if (store.getters.roles.length === 0) { // 判断当前用户是否已拉取完user_info信息
//             await store.dispatch('user/getInfo') // 获取用户信息
//             await store.dispatch('user/getMenu').then(res => { // 拉取菜单
//               let roles = res
//               store.dispatch('GenerateRoutes', { roles }).then(() => { // 生成可访问的路由表
//                 console.log('store', store);
//                 // router.addRoutes(store.state.user.menu) // 动态添加可访问路由表
//                 router.addRoutes(store.state.permission.addRouters) // 动态添加可访问路由表
//                 // router.addRoutes(store.getters.addRouters) // 动态添加可访问路由表
//                 console.log('router', router);
//
//                 next({ ...to, replace: true }) // hack方法 确保addRoutes已完成 ,//菜单权限更新完成,重新进一次当前路由
//               })
//               // })
//             }).catch(err => {
//               console.log(err)
//             })
//             // } else {
//             //   next()
//             // }
//           } catch (error) {
//             // remove token and go to login page to re-login
//             // await store.dispatch('user/resetToken')
//             // Message.error(error || 'Has Error')
//             // next(`/login?redirect=${to.path}`)
//             // NProgress.done()
//             if (whiteList.indexOf(to.path) !== -1) { // 在免登录白名单，直接进入
//               next()
//             } else {
//               next('/login')
//             }
//           }
//         } else {
//           if (to.path === '/login') {
//             next({ name: 'Dashboard' })
//           } else {
//             if (hasPermission(to, store.getters.accessMenu)) {
//               Util.toDefaultPage(store.getters.accessMenu, to, routes, next);
//             } else {
//               next({ path: '/403', replace: true })
//             }
//           }
//         }
//       }
//     }
//   } else {
//     /* has no token*/
//     if (whiteList.indexOf(to.path) !== -1) {
//       // in the free login whitelist, go directly
//       next()
//     } else {
//       // other pages that do not have permission to access are redirected to the login page.
//       next(`/login?redirect=${to.path}`)
//       // NProgress.done()
//     }
//   }
// })
//
// router.afterEach(() => {
//   // finish progress bar
//   // NProgress.done()
// })
