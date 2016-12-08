(ns website.visuals
  (:require [reagent.core :as r]
            [clojure.string :refer [blank?]]
            [website.visuals-service :refer [get-visuals]]))

;; ----------
;; View model

(def filter-query (r/atom ""))

(def visuals-data (r/atom []))

(def filtered-visuals-data (r/atom []))

(get-visuals visuals-data)

;; -----------------------
;; Component functionality

(defn filter-visuals [query]
  (reset! filter-query query)

  (reset! filtered-visuals-data
          (if (blank? @filter-query)
            @visuals-data
            (doall (filter
                    (fn [x]
                      (some #{@filter-query} (x :tags))) @visuals-data)))))


(defn limit-results [results]
  (take 5 results))

;; -------------------------
;; Component to build images

(defn image [data]
  [:a {:class "visual__link" :href (data :image)
       :style {:background-color (data :background)}}
   [:img {:class "visual__img":src (data :image)}]])

;; ----------------------------------
;; Component to build embedded videos

(defn embedded-video [code]
  [:div {:class "visual__embedded-video"
         :dangerouslySetInnerHTML {:__html code}}])

;; -----------------------
;; Single visual component

(defn visual [data]
  [:div {:class (str "visual visual--" (data :type))}

   (if (= (data :type) "image")
     [image data])

   (if (= (data :type) "embedded-video")
     [embedded-video (data :code)])

   [:div {:class "visual__title"} (data :title)
    (doall (for [tag (data :tags)]
             ^{:key tag} [:span {:class (str
                                         "visual__tag noselect "
                                         (if (= tag @filter-query) "visual__tag--active"))
                                 :on-click  #(filter-visuals tag)} tag]))]])

;; ----------------------
;; Visuals page main view

(defn visuals []
  [:div {:class "view view--visuals"}
   [:div {:class "container"}
    [:div {:class "options"}
     [:div {:class "filter"}
      [:input {:type "text"
               :placeholder "filter"
               :class "filter__input"
               :value @filter-query
               :on-change #(filter-visuals (-> % .-target .-value))}]
      [:button {:type "button"
                :class (str "filter__clear-btn" (if (blank? @filter-query) " filter__clear-btn--visible"))
                :on-click #(reset! filter-query "")} "clear"]]]

    [:div {:class "visuals-gallery"}
     (for [item (if (blank? @filter-query)
                  (limit-results @visuals-data)
                  (limit-results @filtered-visuals-data))]
       ^{:key (item :id)} [visual item])]]])
