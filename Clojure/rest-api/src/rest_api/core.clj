(ns rest-api.core
  (:require [org.httpkit.server :as server]
            [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer :all]
            [clojure.pprint :as pp]
            [clojure.string :as str]
            [clojure.data.json :as json])
  (:gen-class))

(defn movie-handler [req]
  {:status  200
   :headers {"Content-Type" "text/json"}
   :body    (str (json/write-str @movie-collection))})

(defn get-parameter [req pname] (get (:params req) pname))

(def movie-collection (atom []))

(defn add-movie [name category]
  (swap! movie-collection conj {:name (str/capitalize name) :category (str/capitalize category)}))

(defn add-movie-handler [req]
  {:status  200
   :headers {"Content-Type" "text/json"}
   :body    (-> (let [p (partial get-parameter req)]
                  (str (json/write-str (add-movie (p :name) (p :category))))))})

(defroutes app-routes
           (GET "/movie" [] movie-handler)
           (POST "/movie/add" [] add-movie-handler)
           (route/not-found "Error, page not found!"))

(defn -main
  "This is our main entry point"
  [& args]
  (let [port (Integer/parseInt (or (System/getenv "PORT") "3000"))]
    ; Run the server with Ring.defaults middleware
    (server/run-server (wrap-defaults #'app-routes site-defaults) {:port port})
    ; Run the server without ring defaults
    ;(server/run-server #'app-routes {:port port})
    (println (str "Running webserver at http:/127.0.0.1:" port "/"))))
