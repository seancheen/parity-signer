//
//  KeyList.swift
//  NativeSigner
//
//  Created by Alexander Slesarev on 19.7.2021.
//

import SwiftUI

struct KeyManager: View {
    @EnvironmentObject var data: SignerDataModel
    @GestureState private var dragOffset = CGSize.zero
    var content: MKeys
    var body: some View {
        ZStack {
            VStack {
                Button(action: {}){
                    SeedKeyCard(seedCard: content.root)
                }.padding(2)
                Button(action: {data.pushButton(buttonID: .NetworkSelector)}) {
                    NetworkCard(content: content.network)
                }
                HStack {
                        Text("DERIVED KEYS").foregroundColor(Color("Text600"))
                        Spacer()
                        Button(action: {
                            //TODO
                        }) {
                            Image(systemName: "plus.circle").imageScale(.large).foregroundColor(Color("Action400"))
                        }
                    }.padding(.horizontal, 8)
                ScrollView {
                    LazyVStack {
                        ForEach(content.set, id: \.address_key) {
                            address in
                            Button(action: {}){
                                AddressCard(address: address)
                            }.padding(2)
                        }
                    }
                }
                Spacer()
            }
        }
        .background(/*@START_MENU_TOKEN@*//*@PLACEHOLDER=View@*/Color("backgroundColor")/*@END_MENU_TOKEN@*/)
    }
}

/*
 struct KeyManager_Previews: PreviewProvider {
 static var previews: some View {
 NavigationView {
 KeyManager()
 }
 }
 }
 */
