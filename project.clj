(defproject secretary "1.2.1"
  :description "A client-side router for ClojureScript."
  :url "https://github.com/gf3/secretary"
  :license {:name "Eclipse Public License - v 1.0"
            :url "http://www.eclipse.org/legal/epl-v10.html"
            :distribution :repo
            :comments "same as Clojure"}

  :dependencies
  [[org.clojure/clojure "1.5.1"]
   [org.clojure/clojurescript "0.0-2156" :scop "provided"]]

  :plugins
  [[lein-cljsbuild "1.0.2"]]

  :profiles
  {:dev {:plugins [[com.cemerick/austin "0.1.3"]
                   [com.cemerick/clojurescript.test "0.2.3-SNAPSHOT"]]}}

  :aliases
  {"run-tests" ["do" "clean," "cljsbuild" "once" "test"]
   "test-once" ["do" "clean," "cljsbuild" "once" "test"]
   "auto-test" ["do" "clean," "cljsbuild" "auto" "test"]}

  :cljsbuild
  {:builds [{:id "test"
             :source-paths ["src/" "test/"]
             :notify-command ["phantomjs" :cljs.test/runner "target/js/test.js"]
             :compiler {:output-to "target/js/test.js"
                        :optimizations :whitespace
                        :pretty-print true}}
            {:id "example-01"
             :source-paths ["src/" "examples/example-01"]
             :compiler {:output-to "examples/example-01/example.js"
                        :optimizations :whitespace
                        :pretty-print true}}]})
