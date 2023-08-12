from django.shortcuts import render,redirect
from pytrends.request import TrendReq
import pandas as pd
import json
pytrends = TrendReq()

resultlist = []
keysrc = [""]
trending = []
tempkeys =[]
geodata = ""
contdata = "united_states"
time ='today 5-y'
catry = 0
location = ''
def home(response):
    global keysrc, contdata, time, catry,location
    dfltlocation = "United States"
    location = response.GET.get('country_name')
    if type(location) == None:
        dfltlocation = "United States"
    if type(location) == str:
        dfltlocation = location
        if ' ' in location:
            location = location.lower()
            contdata = location.replace(" ", "_")
        else:
            contdata = location.lower()
    trending = pytrends.trending_searches(pn=contdata).head(10)
    listofclm = trending.columns
    trending = list(trending[listofclm[0]])
    global keysrc
    if 'searchbox' in response.POST:
        search_data = response.POST.get('searchbox').split(",")
        keysrc = search_data
        if len(search_data) > 0:
            return redirect("/result")
        else:
            print("")
    return render(response, "main/Home.html",{"trendtop" : trending,"result":'/result',"dfltlocation":dfltlocation})

def result(response):
    global geodata
    print(geodata)
    pytrends.build_payload(keysrc, cat=catry, timeframe=time, geo=geodata, gprop='')
    datasrch = pytrends.interest_over_time()
    listcolm = datasrch.columns
    ld = datasrch.index.tolist()
    ld = datasrch.index
    ld_s = [str(inti) for inti in ld]
    ld_s = ",".join(ld_s)
    ld_s = ld_s.split(",")
    testdata =[]
    testdata1 = []
    testdata2 = []
    testdata3 = []
    testdata4 = []
    if len(keysrc) == 1:
        df = pd.DataFrame({'my_timestamp': ld_s,'data' : datasrch[listcolm[0]]})
        listcolm = df.columns
        testdata = df.to_json(orient="records")
        testdata = json.loads(testdata)
        testdata = json.dumps(testdata, indent=4)
    if len(keysrc) == 2:
        df = pd.DataFrame({'my_timestamp': ld_s, 'data': datasrch[listcolm[0]]})
        df1 = pd.DataFrame({'my_timestamp': ld_s, 'data': datasrch[listcolm[1]]})
        listcolm = df.columns
        testdata = df.to_json(orient="records")
        testdata = json.loads(testdata)
        testdata = json.dumps(testdata, indent=4)

        listcolm = df1.columns
        testdata1 = df1.to_json(orient="records")
        testdata1 = json.loads(testdata1)
        testdata1 = json.dumps(testdata1, indent=4)

    if len(keysrc) == 3:
        df = pd.DataFrame({'my_timestamp': ld_s, 'data': datasrch[listcolm[0]]})
        df1 = pd.DataFrame({'my_timestamp': ld_s, 'data': datasrch[listcolm[1]]})
        df2 = pd.DataFrame({'my_timestamp': ld_s, 'data': datasrch[listcolm[2]]})
        listcolm = df.columns
        testdata = df.to_json(orient="records")
        testdata = json.loads(testdata)
        testdata = json.dumps(testdata, indent=4)


        listcolm = df1.columns
        testdata1 = df1.to_json(orient="records")
        testdata1 = json.loads(testdata1)
        testdata1 = json.dumps(testdata1, indent=4)
        listcolm = df2.columns
        testdata2 = df2.to_json(orient="records")
        testdata2 = json.loads(testdata2)
        testdata2 = json.dumps(testdata2, indent=4)

    if len(keysrc) == 4:
        df = pd.DataFrame({'my_timestamp': ld_s, 'data': datasrch[listcolm[0]]})
        df1 = pd.DataFrame({'my_timestamp': ld_s, 'data': datasrch[listcolm[1]]})
        df2 = pd.DataFrame({'my_timestamp': ld_s, 'data': datasrch[listcolm[2]]})
        df3 = pd.DataFrame({'my_timestamp': ld_s, 'data': datasrch[listcolm[3]]})

        listcolm = df.columns
        testdata = df.to_json(orient="records")
        testdata = json.loads(testdata)
        testdata = json.dumps(testdata, indent=4)

        listcolm = df1.columns
        testdata1 = df1.to_json(orient="records")
        testdata1 = json.loads(testdata1)
        testdata1 = json.dumps(testdata1, indent=4)

        listcolm = df2.columns
        testdata2 = df2.to_json(orient="records")
        testdata2 = json.loads(testdata2)
        testdata2 = json.dumps(testdata2, indent=4)


        listcolm = df3.columns
        testdata3 = df3.to_json(orient="records")
        testdata3 = json.loads(testdata3)
        testdata3 = json.dumps(testdata3, indent=4)

    if len(keysrc) == 5:
        df = pd.DataFrame({'my_timestamp': ld_s, 'data': datasrch[listcolm[0]]})
        df1 = pd.DataFrame({'my_timestamp': ld_s, 'data': datasrch[listcolm[1]]})
        df2 = pd.DataFrame({'my_timestamp': ld_s, 'data': datasrch[listcolm[2]]})
        df3 = pd.DataFrame({'my_timestamp': ld_s, 'data': datasrch[listcolm[3]]})
        df4 = pd.DataFrame({'my_timestamp': ld_s, 'data': datasrch[listcolm[4]]})

        listcolm = df.columns
        testdata = df.to_json(orient="records")
        testdata = json.loads(testdata)
        testdata = json.dumps(testdata, indent=4)


        listcolm = df1.columns
        testdata1 = df1.to_json(orient="records")
        testdata1 = json.loads(testdata1)
        testdata1 = json.dumps(testdata1, indent=4)


        listcolm = df2.columns
        testdata2 = df2.to_json(orient="records")
        testdata2 = json.loads(testdata2)
        testdata2 = json.dumps(testdata2, indent=4)


        listcolm = df3.columns
        testdata3 = df3.to_json(orient="records")
        testdata3 = json.loads(testdata3)
        testdata3 = json.dumps(testdata3, indent=4)


        listcolm = df4.columns
        testdata4 = df4.to_json(orient="records")
        testdata4 = json.loads(testdata4)
        testdata4 = json.dumps(testdata4, indent=4)
    related_queries0 = []
    related_topic = []
    related_queries1 = []
    related_queries = []
    related_queries2 = []
    related_queries3 = []
    related_queries4 = []
    if len(keysrc) == 1:
        related_queries = pytrends.related_queries()
        listkeys = related_queries.keys()
        listkeys = list(listkeys)
        related_queries = related_queries[listkeys[0]]["rising"]
        related_queries = related_queries["query"].head(5)
        related_queries = related_queries.tolist()

        related_topic = pytrends.related_topics()
        listkeys = related_topic.keys()
        listkeys = list(listkeys)
        related_topic = related_topic[listkeys[0]]["rising"]["topic_title"].head(5)
        related_topic = related_topic.tolist()
    if len(keysrc) == 2:
        related_queries = pytrends.related_queries()
        listkeys = related_queries.keys()
        listkeys = list(listkeys)
        related_queries0 = related_queries[listkeys[0]]["rising"]
        related_queries1 = related_queries[listkeys[1]]["rising"]
        related_queries0 = related_queries0["query"].head(5)
        related_queries0 = related_queries0.tolist()
        related_queries1 = related_queries1["query"].head(5)
        related_queries1 = related_queries1.tolist()
    if len(keysrc) == 3:
        related_queries = pytrends.related_queries()
        listkeys = related_queries.keys()
        listkeys = list(listkeys)
        related_queries0 = related_queries[listkeys[0]]["rising"]
        related_queries1 = related_queries[listkeys[1]]["rising"]
        related_queries2 = related_queries[listkeys[2]]["rising"]
        related_queries0 = related_queries0["query"].head(5)
        related_queries0 = related_queries0.tolist()
        related_queries1 = related_queries1["query"].head(5)
        related_queries1 = related_queries1.tolist()
        related_queries2 = related_queries2["query"].head(5)
        related_queries2 = related_queries2.tolist()
    if len(keysrc) == 4:
        related_queries = pytrends.related_queries()
        listkeys = related_queries.keys()
        listkeys = list(listkeys)
        related_queries0 = related_queries[listkeys[0]]["rising"]
        related_queries1 = related_queries[listkeys[1]]["rising"]
        related_queries2 = related_queries[listkeys[2]]["rising"]
        related_queries3 = related_queries[listkeys[3]]["rising"]
        related_queries0 = related_queries0["query"].head(5)
        related_queries0 = related_queries0.tolist()
        related_queries1 = related_queries1["query"].head(5)
        related_queries1 = related_queries1.tolist()
        related_queries2 = related_queries2["query"].head(5)
        related_queries2 = related_queries2.tolist()
        related_queries3 = related_queries3["query"].head(5)
        related_queries3 = related_queries3.tolist()
    if len(keysrc) == 5:
        related_queries = pytrends.related_queries()
        listkeys = related_queries.keys()
        listkeys = list(listkeys)
        related_queries0 = related_queries[listkeys[0]]["rising"]
        related_queries1 = related_queries[listkeys[1]]["rising"]
        related_queries2 = related_queries[listkeys[2]]["rising"]
        related_queries3 = related_queries[listkeys[3]]["rising"]
        related_queries4 = related_queries[listkeys[4]]["rising"]
        related_queries0 = related_queries0["query"].head(5)
        related_queries0 = related_queries0.tolist()
        related_queries1 = related_queries1["query"].head(5)
        related_queries1 = related_queries1.tolist()
        related_queries2 = related_queries2["query"].head(5)
        related_queries2 = related_queries2.tolist()
        related_queries3 = related_queries3["query"].head(5)
        related_queries3 = related_queries3.tolist()
        related_queries4 = related_queries4["query"].head(5)
        related_queries4 = related_queries4.tolist()

    return render(response,"main/Result.html",{"keytosrc" : keysrc,"testdata":testdata,"testdata1":testdata1,"testdata2":testdata2,"testdata3":testdata3,"testdata4":testdata4,"related_topic": related_topic,"related_queries" :related_queries,"related_queries0":related_queries0,"related_queries1":related_queries1,"related_queries2": related_queries2,"related_queries3":related_queries3,"related_queries4":related_queries4})