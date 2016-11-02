(ns website.home)

(defn home []
  [:div {:class "view"}
   [:div {:class "view__landing container-fluid"} "Landing animation"]
   [:div {:class "container"} "Some short text about me"]])
