(ns website.visuals
  (:require [reagent.core :as r]
            [clojure.string :refer [blank?]]
            [website.visuals-service :refer [get-visuals]]))

;; ----------
;; View model

(def filter-query (r/atom ""))

(def visuals-data (r/atom []))

(def filtered-visuals-data (r/atom []))

(def page (r/atom 1))

(def max-page (r/atom 1))

(get-visuals visuals-data)

;; -----------------------
;; Component functionality

(defn filter-visuals [query]
  (reset! filter-query query)

  (reset! page 1)

  (reset! filtered-visuals-data
          (vec (doall (filter
                       (fn [x]
                         (some #{@filter-query} (x :tags))) @visuals-data)))))

(defn limit-results [page-number results]
  (js/scroll 0 0)

  (reset! max-page
          (int (Math/ceil
                (/ (count results) 5))))

  (if (> (count results) 5)
    (take 5 (subvec results (* (dec page-number) 5)))
    results))


(defn reset-filter []
  (reset! page 1)
  (reset! filter-query ""))

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

;; -------------------------
;; Pagination component

(defn manage-page [page-number]
  [:div {:class "visuals-pagination noselect"}
   [:a {:class (str "visuals-pagination__arrow visuals-pagination__arrow--left "
                    (if (= page-number 1)
                      "visuals-pagination__arrow--disabled"))
        :href (str "#/visuals/" (dec page-number))}
    [:i {:class "fa fa-long-arrow-left" :aria-hidden "true"}]]

   [:span {:class "visuals-pagination__current"} page-number]

   [:a {:class (str "visuals-pagination__arrow visuals-pagination__arrow--right "
                    (if (= page-number @max-page)
                      "visuals-pagination__arrow--disabled"))
        :href (str "#/visuals/" (inc page-number))}
    [:i {:class "fa fa-long-arrow-right" :aria-hidden "true"}]]])

;; ----------------------
;; Visuals page main view

(defn visuals [page-number]
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
                :on-click reset-filter} "clear"]
      [:div {:class "filter__progress"}]]]

    [:div {:class "visuals-gallery"}
     (for [item (limit-results page-number (if (blank? @filter-query)
                                             @visuals-data
                                             @filtered-visuals-data))]
       ^{:key (item :id)} [visual item])]

    [manage-page page-number]]])
