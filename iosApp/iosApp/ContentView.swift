import SwiftUI
import shared

struct ContentView: View {
    @State var text = "0"
	var body: some View {
        VStack(spacing: 50){
		Text(text)
        Button(action: {
            getRes()}) {
                Text("Get")
                    .padding(.all)
                    .background(Color.gray)
                    .cornerRadius(16)
                    .shadow(color: Color.gray, radius: 10, x: 10, y: 10)
        }
        }
	}
    func getRes() {
        let view = MyView(v: self)
        let p = Presenter(view: view)
        p.onButtonClick()
    }
    func showResult(result: String) {
        text = result
    }
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}

class MyView: IView {
    var v: ContentView
    init(v: ContentView) {
        self.v = v
    }
    func showResult(result: String) {
        v.showResult(result: result)
    }
    
    
}
