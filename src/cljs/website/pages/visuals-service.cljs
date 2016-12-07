(ns website.visuals-service
  (:require [ajax.core :refer [GET]]))

(defn get-visuals [data-container]
  (GET "/data/visuals.json" {:response-format :json
                             :keywords? true

                             :handler (fn [data]
                                        (reset! data-container (data :visuals)))

                             :error-handler (fn [error]
                                              (throw (js/Error. "Error encountered while getting visuals data!")))}))
